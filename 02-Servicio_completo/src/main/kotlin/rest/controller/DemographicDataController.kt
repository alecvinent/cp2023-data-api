package rest.controller

import io.javalin.http.Context
import kotlinx.coroutines.runBlocking
import rest.dto.toDto
import service.DemographicDataService

class DemographicDataController(
    private val demographicDataService: DemographicDataService
) {
    fun getDemographicData(ctx: Context) {
        val demographicDataRetrieved = demographicDataService.mergeCompositeIndices()
        ctx.json(demographicDataRetrieved.toDto())
    }

    fun getDemographicDataWithCoroutine(ctx: Context) {
        runBlocking {
            val demographicDataRetrieved = demographicDataService.mergeCompositeIndicesWithCoroutines()
            ctx.json(demographicDataRetrieved.toDto())
        }
    }
}
