package repository.interfaces

import model.Country
import model.DataSet

interface DemographicDataRepository {
    fun getDemographicData(country: Country,dataSet: DataSet)
}