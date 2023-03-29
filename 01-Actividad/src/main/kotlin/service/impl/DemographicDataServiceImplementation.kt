package service.impl

import model.CompositeIndices
import model.Country
import model.CountryData
import model.DataSet
import repository.DemographicDataRepository
import service.DemographicDataService

class DemographicDataServiceImplementation(private val csvRepository: DemographicDataRepository) : DemographicDataService {
    override fun getGiiInfo(): Map<String, CountryData> {

        /**
         *  Ejercicio 1 Impelemnar
         */

        val worldGiiInfo = csvRepository.getDemographicDataByDataSet(Country.WORLD, DataSet.GII)
        val latamGiiInfo = TODO()
        val uruguayGiiInfo = TODO()

        val worldCountryData = CountryData(Country.WORLD, worldGiiInfo)
        val latamCountryData = TODO()
        val uruguayCountryData = TODO()

        return mapOf( Pair("World", worldCountryData) , Pair("Latam", latamCountryData), Pair("Uruguay", uruguayCountryData))
    }

    override fun getGdiInfo(): Map<String, CountryData> {
        /**
         *  Ejercicio 2- Implementar la función getGdiInfo()
          */

        TODO()
    }

    fun mergeCompositeIndicesWithReturn(): CompositeIndices {
        val giiInfo = getGiiInfo()
        val gdiInfo = getGdiInfo()
        return CompositeIndices(giiIndex = giiInfo, gdiIndex = gdiInfo)
    }

    // Ejercicio 3 - Convertir la funcion mergeCompositeIndicesWithReturn a otra que
    // funcione exactamente igual pero utilizando una sola linea de codigo!
    // override fun mergeCompositeIndices(): CompositeIndices = TODO()
}
