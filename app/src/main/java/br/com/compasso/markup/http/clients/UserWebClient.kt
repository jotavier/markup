package br.com.compasso.markup.http.clients


import br.com.compasso.markup.data.models.CheckIn
import br.com.compasso.markup.http.dtos.CheckInDTO
import br.com.compasso.markup.http.services.CheckInService
import javax.net.ssl.HttpsURLConnection

class UserWebClient(private val checkInService: CheckInService) : WebClient() {

    fun execute(
        checkIn: CheckIn,
        onSuccess: (code: Int) -> Unit,
        onError: (message: String) -> Unit
    ) {
        val checkInDataDTO = CheckInDTO(
            checkIn.user?.name,
            checkIn.user?.email,
            checkIn.eventId
        )
        request(
            checkInService.checkIn(checkInDataDTO),
            onSuccess = {
                val checkInResult = it.toModel()
                if (checkInResult.code != HttpsURLConnection.HTTP_OK) {
                    onError("Não foi possível realizar o check-in (${checkInResult.code})")
                    return@request
                }
                onSuccess(checkInResult.code)
            },
            onError = onError
        )
    }
}
