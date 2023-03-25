package repository

import model.Country
import model.DataSet
import model.DemographicData

interface DemographicDataRepository {
    fun getDemographicDataByDataSet(country: Country, dataSet: DataSet): List<DemographicData>
}