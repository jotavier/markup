package br.com.compasso.findit.http.clients

import br.com.compasso.findit.data.models.Event
import br.com.compasso.findit.http.services.EventService


class EventWebClient(
    private val eventService: EventService
) : WebClient() {
    fun all(
        onSuccess: (events: List<Event>) -> Unit,
        onError: (message: String) -> Unit
    ) {
        request(
            eventService.events(),
            onSuccess = { onSuccess(it.map { dto -> dto.toModel() }) },
            onError = onError
        )
    }
}
