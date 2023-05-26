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
        val worldGiiInfo = csvRepository.getDemographicDataByDataSet(Country.WORLD, DataSet.GII)
        val latamGiiInfo = csvRepository.getDemographicDataByDataSet()
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


    // Ejercicio 3 - Convertir la funcion mergeCompositeIndicesWithReturn a otra que
    // funcione exactamente igual pero utilizando una sola linea de codigo!
    // override fun mergeCompositeIndeces(): CompositeIndices = TODO()

    fun mergeCompositeIndicesWithReturn(): CompositeIndices {
        val giiInfo = getGiiInfo()
        val gdiInfo = getGdiInfo()
        return CompositeIndices(giiIndex = giiInfo, gdiIndex = gdiInfo)
    }

    //Una vez resuelto el ejercicio 3, intenta obtener los datos de los indices desde tu navegador apartir de la siguiente
    // url: http://localhost:8081/v1/demographicData



    // Ejercicio 4 [OPCIONAL] - Apartir de las funciones implementadas anteriormente (getGiiInfo() getGdiInfo())
    // ahora implementemos una funcion que retorne al igual que el ejercicio 3, un CompositeIndices pero ahora
    // utilizando corrutinas
    override suspend fun mergeCompositeIndicesWithCoroutines(): CompositeIndices {
        TODO()
    }

    //Una vez resuelto el ejercicio 4, intenta obtener los datos de los indices desde tu navegador apartir de la siguiente
    // url: http://localhost:8081/v1/demographicData/coroutine
}
