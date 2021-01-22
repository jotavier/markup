package br.com.compasso.markup.http.clients

import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.http.services.EventService


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
