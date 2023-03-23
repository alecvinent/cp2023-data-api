package controller.dto

import model.CompositeIndices
import model.CountryData
import model.DemographicData

data class CompositeIndicesDto(
        val giiIndex: List<CountryData>,
        val gdiIndex: List<CountryData>
) {

    fun toModel() = CompositeIndices(
            giiIndex = giiIndex,
            gdiIndex = gdiIndex
    )
}