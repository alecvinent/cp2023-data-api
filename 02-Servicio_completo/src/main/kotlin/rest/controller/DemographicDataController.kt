package rest.controller

import io.javalin.http.Context
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import rest.dto.toDto
import service.DemographicDataService

class DemographicDataController(
    private val demographicData: DemographicDataService
) {
    fun getDemographicData(ctx: Context) {
        val demographicDataRetrieved = demographicData.mergeCompositeIndices()
        ctx.json(demographicDataRetrieved.toDto())
    }

    fun getDemographicDataWithCoroutine(ctx: Context) {
        runBlocking {
            val demographicDataRetrieved = demographicData.mergeCompositeIndicesWithCoroutines()
            ctx.json(demographicDataRetrieved.toDto())
        }
    }
}
