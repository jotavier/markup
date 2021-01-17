package br.com.compasso.findit.http.clients


import br.com.compasso.findit.data.models.Person
import br.com.compasso.findit.http.dtos.PersonDTO
import br.com.compasso.findit.http.services.PersonService
import javax.net.ssl.HttpsURLConnection

class PersonWebClient(private val personService: PersonService) : WebClient() {

    fun checkIn(
        person: Person,
        onSuccess: (person: Person) -> Unit,
        onError: (message: String) -> Unit
    ) {
        val personDTO = PersonDTO(
            person.name,
            person.email,
            person.eventId
        )
        request(
            personService.checkIn(personDTO),
            onSuccess = {
                val checkIn = it.toModel()
                if (checkIn.code != HttpsURLConnection.HTTP_OK) {
                    onError("Não foi possível realizar o check-in (${checkIn.code})")
                    return@request
                }
                onSuccess(person)
            },
            onError = onError
        )
    }
}
