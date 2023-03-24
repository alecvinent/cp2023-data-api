package rest.controller

import io.javalin.http.Context
import rest.dto.toDto
import services.DemographicDataService

class DemographicDataController(
        private val demographicData: DemographicDataService
) {
    fun getDemographicData(ctx: Context) {
        val demographicDataRetrieved = demographicData.mergeCompositeIndices()
        ctx.json(demographicDataRetrieved.toDto())
    }
}
