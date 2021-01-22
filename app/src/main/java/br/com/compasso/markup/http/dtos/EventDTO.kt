package br.com.compasso.markup.http.dtos

import br.com.compasso.markup.data.interfaces.IDataTransferObject
import br.com.compasso.markup.data.models.Event
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class EventDTO(
    private val id: Long,
    private val people: List<String>?,
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
        people,
        image,
        longitude,
        latitude,
        price,
        title
    )
}