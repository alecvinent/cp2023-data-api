package controller

import io.javalin.http.Context
import services.DemographicDataService

class DemographicDataController(
        private val demographicData: DemographicDataService
) {
    fun getDemographicData(ctx: Context) {
        val demographicDataRetrived = demographicData.mergeCompositeIndices()
        ctx.json(demographicDataRetrived.toDto())
    }
}
