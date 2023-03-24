package modules

import controller.DemographicDataController

data class ControllerModule(
        val demographicDataController: DemographicDataController
) {
    companion object{
        fun create(serviceModule: ServiceModule ): ControllerModule {
            return ControllerModule(
                    demographicDataController = DemographicDataController(serviceModule.demographicData)
            )
        }
    }

}