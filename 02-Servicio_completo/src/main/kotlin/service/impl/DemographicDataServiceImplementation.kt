package service.impl

import kotlinx.coroutines.GlobalScope
import model.CompositeIndices
import model.Country
import model.CountryData
import model.DataSet
import repository.DemographicDataRepository
import service.DemographicDataService
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class DemographicDataServiceImplementation(private val csvRepository: DemographicDataRepository) : DemographicDataService {
    override fun getGiiInfo(): Map<String, CountryData> {
        val worldGiiInfo = csvRepository.getDemographicDataByDataSet(Country.WORLD, DataSet.GII)
        val latamGiiInfo = csvRepository.getDemographicDataByDataSet(Country.LATAM, DataSet.GII)
        val uruguayGiiInfo = csvRepository.getDemographicDataByDataSet(Country.URUGUAY, DataSet.GII)

        val worldCountryData = CountryData(Country.WORLD, worldGiiInfo)
        val latamCountryData = CountryData(Country.LATAM, latamGiiInfo)
        val uruguayCountryData = CountryData(Country.URUGUAY, uruguayGiiInfo)

        return mapOf( Pair("World", worldCountryData) , Pair("Latam", latamCountryData), Pair("Uruguay", uruguayCountryData))
    }

    override fun getGdiInfo(): Map<String, CountryData> {
        val worldGdiInfo = csvRepository.getDemographicDataByDataSet(Country.WORLD, DataSet.GDI)
        val latamGdiInfo = csvRepository.getDemographicDataByDataSet(Country.LATAM, DataSet.GDI)
        val uruguayGdiInfo = csvRepository.getDemographicDataByDataSet(Country.URUGUAY, DataSet.GDI)

        val worldCountryData = CountryData(Country.WORLD, worldGdiInfo)
        val latamCountryData = CountryData(Country.LATAM, latamGdiInfo)
        val uruguayCountryData = CountryData(Country.URUGUAY, uruguayGdiInfo)

        return mapOf( Pair("World", worldCountryData) , Pair("Latam", latamCountryData), Pair("Uruguay", uruguayCountryData))
    }

    override fun mergeCompositeIndices(): CompositeIndices = CompositeIndices(getGiiInfo(), getGdiInfo())


    override suspend fun mergeCompositeIndicesWithCoroutines(): CompositeIndices {

        val giiIndex = GlobalScope.async {
            getGiiInfo()
        }

        val gdiIndex = GlobalScope.async {
            getGdiInfo()
        }

        return CompositeIndices(giiIndex.await(), gdiIndex.await())
    }
}
