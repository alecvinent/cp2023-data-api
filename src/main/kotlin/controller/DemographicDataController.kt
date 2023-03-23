package controller

import io.javalin.http.Context
import io.javalin.plugin.openapi.dsl.documented
import services.DemographicDataService
import java.nio.file.Paths.get

class DemographicDataController(
        private val demographicData: DemographicDataService
) {
    fun routes(){
        get("dummy/")
    }
    fun getDemographicData(ctx: Context) {
        val demographicDataRetrived = demographicData.mergeCompositeIndices()
        ctx.json(demographicDataRetrived.toDto())
    }
}