package br.com.compasso.findit.http.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import br.com.compasso.findit.data.models.Event
import br.com.compasso.findit.database.daos.EventDAO
import br.com.compasso.findit.http.clients.EventWebClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventRepository(
    private val eventDAO: EventDAO,
    private val eventWebClient: EventWebClient
) {

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
                CoroutineScope(Dispatchers.IO).launch { eventDAO.save(events) }
            },
            onError = { message ->
                error.value = Resource.failure(message)
            }
        )
    }
}