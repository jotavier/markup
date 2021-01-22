package br.com.compasso.markup.http.dtos

import br.com.compasso.markup.data.interfaces.IDataTransferObject
import br.com.compasso.markup.data.models.CheckIn
import br.com.compasso.markup.data.models.User
import kotlinx.parcelize.Parcelize

@Parcelize
class CheckInDTO(
    private val name: String?,
    private val email: String?,
    private val eventId: Long
) : IDataTransferObject<CheckIn> {

    override fun toModel() = CheckIn(
        user = User(name, email),
        eventId = eventId
    )
}