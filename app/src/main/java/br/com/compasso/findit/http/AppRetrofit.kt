package br.com.compasso.findit.http

import br.com.compasso.findit.http.services.EventService
import br.com.compasso.findit.http.services.PersonService

class AppRetrofit(
    connection: Connection
) {
    val eventService: EventService by lazy {
        connection.build().create(EventService::class.java)
    }

    val personService: PersonService by lazy {
        connection.build().create(PersonService::class.java)
    }
}