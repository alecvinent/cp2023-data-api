package model

data class CompositeIndices(
    val giiIndex: Map<String,CountryData>,
    val gdiIndex: Map<String,CountryData>
)
