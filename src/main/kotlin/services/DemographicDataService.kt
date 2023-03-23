package services

import model.CompositeIndices
import model.CountryData

interface DemographicDataService {
    fun getGiiInfo(): List<CountryData>
    fun getGdiInfo(): List<CountryData>
    fun mergeCompositeIndices(): CompositeIndices
}