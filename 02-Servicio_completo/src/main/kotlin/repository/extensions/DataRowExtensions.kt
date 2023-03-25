package repository.extensions

import model.DataSet
import model.DemographicData
import org.jetbrains.kotlinx.dataframe.DataRow
import org.jetbrains.kotlinx.dataframe.api.columnNames

fun <T> DataRow<T>.parseToDemographicData(dataSet: DataSet): List<DemographicData> {
    val allDemographicDataForDataSet = mutableListOf<DemographicData>()

    for (i in 1..20){
        allDemographicDataForDataSet.add(
            DemographicData(
                year = this.columnNames()[i].removePrefix(dataSet.getColumnPrefix()).toInt(),
                value = this.values()[i] as Double
            )
        )
    }

    return allDemographicDataForDataSet
}
