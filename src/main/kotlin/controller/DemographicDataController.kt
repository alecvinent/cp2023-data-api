package controller

import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.http.Context
import io.javalin.plugin.openapi.dsl.document
import io.javalin.plugin.openapi.dsl.documented
import services.DemographicDataService

class DemographicDataController(
        private val demographicData: DemographicDataService
) {
    fun routes() {
        path("/v1/demographicData") {
            get(documented(getDemographicDataDoc, ::getDemographicData))
        }
    }

    private val getDemographicDataDoc = document().json<String>("200")

    fun getDemographicData(ctx: Context) {
        val demographicDataRetrived = demographicData.mergeCompositeIndices()
        ctx.json(demographicDataRetrived.toDto())
    }
}
