package br.com.compasso.findit.http.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.compasso.findit.data.models.Person
import br.com.compasso.findit.database.daos.PersonDAO
import br.com.compasso.findit.http.clients.PersonWebClient

class PersonRepository(
    private val personDAO: PersonDAO,
    private val personWebClient: PersonWebClient
) {
    fun checkIn(person: Person): LiveData<Resource<Person?>> {
        val checkOut = MutableLiveData<Resource<Person?>>(Resource.loading())
        personWebClient.checkIn(person,
            onSuccess = {
                checkOut.value = Resource.success(it)
            },
            onError = { message ->
                checkOut.value = Resource.failure(message)
            })
        return checkOut
    }
}
