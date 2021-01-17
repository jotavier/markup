package br.com.compasso.findit.http.services

import br.com.compasso.findit.http.dtos.CheckInDTO
import br.com.compasso.findit.http.dtos.PersonDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PersonService {

    @POST("checkin")
    fun checkIn(@Body personDTO: PersonDTO): Call<CheckInDTO>
}
