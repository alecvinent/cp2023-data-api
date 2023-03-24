package modules

import services.DemographicDataService
import services.impl.DemographicDataServiceImplementation

data class ServiceModule(
        val demographicData: DemographicDataService
) {
    companion object {
        fun create(dbModule: DbModule): ServiceModule {
            return ServiceModule(
                    demographicData = DemographicDataServiceImplementation(dbModule.demographicData)
            )
        }
    }
}