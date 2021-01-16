package br.com.compasso.findit.http.dtos

import br.com.compasso.findit.data.interfaces.IDataTransferObject
import br.com.compasso.findit.data.models.Person
import kotlinx.parcelize.Parcelize

@Parcelize
class PersonDTO(
    private val name: String,
    private val email: String,
    private val eventId: Int
) : IDataTransferObject<Person> {

    override fun toModel() = Person(
        name,
        email,
        eventId
    )
}