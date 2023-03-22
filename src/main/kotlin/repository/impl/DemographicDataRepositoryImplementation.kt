package repository.impl

import com.opencsv.CSVReader
import model.Country
import model.CountryData
import model.DataSet
import model.DemographicData
import repository.DemographicDataRepository
import java.io.FileReader

class DemographicDataRepositoryImplementation : DemographicDataRepository {
    override fun getDemographicDataByDataSet(country: Country, dataSet: DataSet): List<CountryData> {
        val obtainedCsv = readCsv()
        val headerList = mutableListOf<String?>()
        val worldRaw = mutableMapOf<String, String?>()
        val latamRaw = mutableMapOf<String, String?>()
        val uruguayRaw = mutableMapOf<String, String?>()

        for (element in obtainedCsv.withIndex()) {
            when {
                element.index in 0..59 && element.value.toString().uppercase().contains(dataSet.toString()) -> headerList.add(element.value)
                element.index in 60..119 -> parseDemographicData(element, headerList, worldRaw)
                element.index in 120..179 -> parseDemographicData(element, headerList, latamRaw)
                element.index in 180..239 -> parseDemographicData(element, headerList, uruguayRaw)
            }
        }

        return listOf(
            createCountryData(Country.WORLD, dataSet, worldRaw),
            createCountryData(Country.LATAM, dataSet, latamRaw),
            createCountryData(Country.URUGUAY, dataSet, worldRaw)
        )
    }

    private fun createCountryData(
        country: Country,
        dataSet: DataSet,
        countryRaw: MutableMap<String, String?>
    ): CountryData = CountryData(
        country,
        countryRaw.map {
            DemographicData(
                year = it.key.removePrefix(dataSet.toString()+"_").toInt(),
                value = it.value?.toDouble() ?: 0.0
            )
        }
    )

    private fun parseDemographicData(
        element: IndexedValue<String?>,
        headerList: MutableList<String?>,
        countryRaw: MutableMap<String, String?>
    ) {
        val headerIndex = getHeaderIndex(element.index)
        headerList[headerIndex]?.let { countryRaw.put(it, element.value) }
    }

    private fun getHeaderIndex(elementIndex: Int): Int {
        var headerIndex = elementIndex
        while (elementIndex>60) {
            headerIndex-=60
        }
        return headerIndex
    }

    private fun readCsv(): MutableList<String?> {
        val csvReader = CSVReader(FileReader(object {}.javaClass.getResource(csvPath).path)) //TODO("Refactor he way to obtain the csv file")
        val list = mutableListOf<String?>()
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