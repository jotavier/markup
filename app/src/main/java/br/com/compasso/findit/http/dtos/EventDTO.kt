package br.com.compasso.findit.http.dtos

import br.com.compasso.findit.data.interfaces.IDataTransferObject
import br.com.compasso.findit.data.models.Event
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class EventDTO(
    private val id: Long,
    private val people: List<PersonDTO>?,
    private val date: Long,
    private val description: String,
    private val image: String,
    private val longitude: Double,
    private val latitude: Double,
    private val price: BigDecimal,
    private val title: String
) : IDataTransferObject<Event> {

    override fun toModel() = Event(
        id,
        date,
        description,
        people?.map { personDto -> personDto.toModel() },
        image,
        longitude,
        latitude,
        price,
        title
    )
}