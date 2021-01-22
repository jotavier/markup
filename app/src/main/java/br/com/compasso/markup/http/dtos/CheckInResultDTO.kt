package br.com.compasso.markup.http.dtos

import br.com.compasso.markup.data.interfaces.IDataTransferObject
import br.com.compasso.markup.data.models.CheckInResult
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckInResultDTO(
    private val code: Int
) : IDataTransferObject<CheckInResult> {
    override fun toModel() = CheckInResult(code)
}