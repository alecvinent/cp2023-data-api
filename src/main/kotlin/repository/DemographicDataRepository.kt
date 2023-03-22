package repository

import model.Country
import model.CountryData
import model.DataSet

interface DemographicDataRepository {
    fun getDemographicDataByDataSet(country: Country, dataSet: DataSet): List<CountryData>
}