package model

import controller.dto.CompositeIndicesDto

data class CompositeIndices(
    val giiIndex: List<CountryData>,
    val gdiIndex: List<CountryData>
){
    fun toDto(): CompositeIndicesDto = CompositeIndicesDto(giiIndex, gdiIndex)
}