package controller.dto

import model.DemographicData

data class DemographicDataDto(
        val year: Int,
        val value: Double
) {

    fun toModel() = DemographicData(
            year = year,
            value = value
    )
}