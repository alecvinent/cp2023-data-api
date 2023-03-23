package controller

import io.javalin.http.Context

class DemographicDataController() {

    fun getDemographicData(ctx: Context) {
        val demographicDataRetrived = "Service ger"
        ctx.json(demographicDataRetrived).body()
    }
}