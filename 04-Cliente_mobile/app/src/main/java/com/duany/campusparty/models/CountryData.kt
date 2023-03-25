package com.duany.demo.models


data class CompositeIndices(
    val giiIndex: Map<String,CountryData>,
    val gdiIndex: Map<String, CountryData>
)

enum class Country {
    WORLD,
    LATAM,
    URUGUAY
}

data class CountryData (
    var country: Country,
    var data: List<DemographicData>
)

data class DemographicData(
    val year: Int,
    val value: Float
)

