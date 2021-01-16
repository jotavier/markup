package br.com.compasso.findit.http.services

import retrofit2.http.GET

interface EventService {

    @GET("/events")
    fun events()
}