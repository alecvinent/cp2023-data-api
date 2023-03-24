package controller.dto

import model.CompositeIndices
import model.CountryData

data class CompositeIndicesDto(
        val giiIndex: Map<String, CountryData>,
        val gdiIndex: Map<String, CountryData>
) {

    fun toModel() = CompositeIndices(
            giiIndex = giiIndex,
            gdiIndex = gdiIndex
    )
}
