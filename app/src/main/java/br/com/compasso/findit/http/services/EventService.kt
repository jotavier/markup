package br.com.compasso.findit.http.services

import br.com.compasso.findit.http.dtos.EventDTO
import retrofit2.Call
import retrofit2.http.GET

interface EventService {

    @GET("events")
    fun events(): Call<List<EventDTO>>
}