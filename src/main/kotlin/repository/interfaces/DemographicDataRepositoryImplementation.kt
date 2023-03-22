package repository.interfaces

import com.opencsv.CSVReader
import model.Country
import model.DataSet
import java.io.FileReader

class DemographicDataRepositoryImplementation : DemographicDataRepository {
    override fun getDemographicData(country: Country, dataSet: DataSet) {
        val obtainedCsv = readCsv()
        var headerList = mutableListOf<String?>()
        var worldRaw = mutableListOf<String?>()
        var latamRaw = mutableListOf<String?>()
        var uruguayRaw = mutableListOf<String?>()

        for (elemento in obtainedCsv.withIndex()/*.filter { elem ->
            elem.value.toString().uppercase().contains(dataSet.toString())
        }*/) {
            when {
                elemento?.index in 0..59 && elemento.value.toString().uppercase().contains(dataSet.toString()) -> headerList.add(elemento.value)
                elemento?.index in 60..119 -> worldRaw.add(elemento.value)
                elemento?.index in 120..179 -> latamRaw.add(elemento.value)
                elemento?.index in 180..239 -> uruguayRaw.add(elemento.value)
            }
        }
        headerList
    }

    init {
        readCsv()
        getDemographicData(Country.LATAM, DataSet.GDI)
    }

    private fun readCsv(): MutableList<String?> {
        val csvReader = CSVReader(FileReader(object {}.javaClass.getResource(csvPath).path))
        var list = mutableListOf<String?>()
        var record: Array<String>?

        while (csvReader.readNext().also { record = it } != null) {
            record?.forEach { elemento ->
                list.add(elemento)
            }
        }
        csvReader.close()
        return list
    }

    companion object {
        const val csvPath = "/GDI_GII_URUGUAY_LAC_WORLD1.csv"
    }
}