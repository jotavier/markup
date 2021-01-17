package br.com.compasso.findit.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.compasso.findit.http.repositories.EventRepository

class EventsViewModel(
    private val eventRepository: EventRepository
) : ViewModel() {

    fun load() = eventRepository.all()
}
