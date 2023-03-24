package model

import controller.dto.CompositeIndicesDto

data class CompositeIndices(
    val giiIndex: Map<String,CountryData>,
    val gdiIndex: Map<String,CountryData>
){
    fun toDto(): CompositeIndicesDto = CompositeIndicesDto(giiIndex, gdiIndex)
}
