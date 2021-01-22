package br.com.compasso.markup.http

import br.com.compasso.markup.http.services.EventService
import br.com.compasso.markup.http.services.CheckInService

class AppRetrofit(
    connection: Connection
) {
    val eventService: EventService by lazy {
        connection.build().create(EventService::class.java)
    }

    val checkInService: CheckInService by lazy {
        connection.build().create(CheckInService::class.java)
    }
}