package br.com.compasso.markup.http.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.database.daos.EventDAO
import br.com.compasso.markup.http.clients.EventWebClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventRepository(
    private val eventDAO: EventDAO,
    private val eventWebClient: EventWebClient
) {

    private companion object {
        const val EVENT_LIKE_ERROR_MESSAGE = "Não foi possível curtir este evento"
    }

    private val eventsMediator =
        MediatorLiveData<Resource<List<Event>?>>().also { it.value = Resource.loading() }

    fun all(): LiveData<Resource<List<Event>?>> {
        eventsMediator.addSource(eventDAO.all()) { events ->
            eventsMediator.value = Resource.success(events)
        }

        requestEvents()
        return eventsMediator
    }

    private fun requestEvents() {
        val error = MutableLiveData<Resource<List<Event>?>>()
        eventsMediator.addSource(error) {
            eventsMediator.value?.cache(it)
        }

        eventWebClient.all(
            onSuccess = { events ->
                CoroutineScope(Dispatchers.IO).launch {
                    val localEvents = eventDAO.allLocal()
                    update(localEvents, events)
                    eventDAO.save(events)
                }
            },
            onError = { message ->
                error.value = Resource.failure(message)
            }
        )
    }

    private fun update(localEvents: List<Event>, events: List<Event>) {
        localEvents.forEach { mEvent ->
            events.forEach { event ->
                if (event.id == mEvent.id) {
                    event.favorite = mEvent.favorite
                }
            }
        }
    }

    fun like(event: Event): LiveData<Resource<Void?>> {
        val update = MutableLiveData<Resource<Void?>>()
        CoroutineScope(Dispatchers.IO).launch {
            val rows = eventDAO.update(event)
            if (rows > 0) {
                update.postValue(Resource.success(null))
                return@launch
            }
            update.postValue(Resource.failure(EVENT_LIKE_ERROR_MESSAGE))
        }
        return update
    }

    fun favorites() = eventDAO.favorites()
}