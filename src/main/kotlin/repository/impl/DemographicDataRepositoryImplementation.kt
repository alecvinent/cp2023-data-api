package repository.impl

import extensions.getColumnPrefix
import extensions.parseToDemographicData
import model.Country
import model.DataSet
import model.DemographicData
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.first
import org.jetbrains.kotlinx.dataframe.api.remove
import org.jetbrains.kotlinx.dataframe.io.read
import repository.DemographicDataRepository
import repository.exceptions.CsvFileNotFoundException

class DemographicDataRepositoryImplementation : DemographicDataRepository {
    override fun getDemographicDataByDataSet(country: Country, dataSet: DataSet): List<DemographicData> {
        val dataFrame = DataFrame.read(this.javaClass.getResource(csvPath) ?: throw CsvFileNotFoundException(csvPath))

        val columnsToFilter = getColumnsToFilter(dataSet)
        val resultRow = dataFrame
                            .remove(*columnsToFilter.toTypedArray())
                            .first { (it["country"] as String).uppercase() == country.toString() }

        return resultRow.parseToDemographicData(dataSet)
    }

    private fun getColumnsToFilter(dataSet: DataSet): List<String> {
        val dataSetToRemove = when(dataSet) {
            DataSet.GII -> DataSet.GDI
            DataSet.GDI -> DataSet.GII
        }
        return (2002..2021).map { dataSetToRemove.getColumnPrefix()+it }
    }

    companion object {
        const val csvPath = "/GDI_GII_URUGUAY_LAC_WORLD1.csv"
    }
}