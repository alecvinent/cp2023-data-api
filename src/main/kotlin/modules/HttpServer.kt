package modules

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get

object HttpServer {
    const val PORT = 8081

    fun start(controllerModule: ControllerModule) {
        Javalin.create().routes {
            routes(controllerModule)
        }.start(PORT)
    }

    private fun routes(controllerModule: ControllerModule) {
        with(controllerModule){
            get("/v1/demographicData") { ctx -> demographicDataController.getDemographicData(ctx) }
        }
    }
}