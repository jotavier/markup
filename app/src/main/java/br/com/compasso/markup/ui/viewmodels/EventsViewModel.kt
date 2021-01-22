package br.com.compasso.markup.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.http.repositories.EventRepository
import br.com.compasso.markup.http.repositories.UserRepository

class EventsViewModel(
    private val userRepository: UserRepository,
    private val eventRepository: EventRepository
) : ViewModel() {

    fun load() = eventRepository.all()

    fun isAuthenticated(): LiveData<Boolean> {
        val isAuthenticated = MutableLiveData(false)
        val user = userRepository.load()
        if (user != null) {
            isAuthenticated.value = true
        }
        return isAuthenticated
    }

    fun like(event: Event) = eventRepository.like(event)

    fun favorites() = eventRepository.favorites()
}
