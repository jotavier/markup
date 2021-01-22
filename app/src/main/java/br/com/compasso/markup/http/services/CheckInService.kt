package br.com.compasso.markup.http.services

import br.com.compasso.markup.http.dtos.CheckInDTO
import br.com.compasso.markup.http.dtos.CheckInResultDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CheckInService {

    @POST("checkin")
    fun checkIn(@Body checkInDTO: CheckInDTO): Call<CheckInResultDTO>
}
