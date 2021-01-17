package br.com.compasso.findit.http.dtos

import br.com.compasso.findit.data.interfaces.IDataTransferObject
import br.com.compasso.findit.data.models.CheckIn
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckInDTO(
    private val code: Int?
) : IDataTransferObject<CheckIn> {

    override fun toModel() = CheckIn(code)
}