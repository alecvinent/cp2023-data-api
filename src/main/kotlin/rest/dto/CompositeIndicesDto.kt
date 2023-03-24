package rest.dto

import model.CompositeIndices
import model.CountryData

data class CompositeIndicesDto(
        val giiIndex: Map<String, CountryData>,
        val gdiIndex: Map<String, CountryData>
)


fun CompositeIndices.toDto() = CompositeIndicesDto(giiIndex, gdiIndex)
