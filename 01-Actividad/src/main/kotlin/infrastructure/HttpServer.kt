package infrastructure

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.config.JavalinConfig
import io.javalin.plugin.bundled.CorsContainer
import io.javalin.plugin.bundled.CorsPluginConfig

object HttpServer {
    private const val PORT = 8081

    fun start(controllerModule: ControllerModule) {
        Javalin.create{ config: JavalinConfig ->
            config.plugins.enableCors { cors: CorsContainer ->
                cors.add { it: CorsPluginConfig ->
                    it.allowHost(
                        "http://localhost:4200"
                    )
                }
            }
        }.routes { routes(controllerModule) }.start(PORT)
    }

    private fun routes(controllerModule: ControllerModule) {
        with(controllerModule){
            get("/v1/demographicData") { ctx -> demographicDataController.getDemographicData(ctx) }
        }
    }
}
