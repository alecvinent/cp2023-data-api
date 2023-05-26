package service

import model.CompositeIndices
import model.CountryData

interface DemographicDataService {
    fun getGiiInfo(): Map<String,CountryData>
    fun getGdiInfo(): Map<String, CountryData>
    fun mergeCompositeIndices(): CompositeIndices
    suspend fun mergeCompositeIndicesWithCoroutines(): CompositeIndices
}
