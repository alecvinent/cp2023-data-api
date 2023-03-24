package infrastructure

import repository.DemographicDataRepository
import repository.impl.DemographicDataRepositoryImplementation

data class DbModule(
    val demographicData: DemographicDataRepository
){
    companion object {
        fun create(): DbModule{
            return DbModule(
                    demographicData = DemographicDataRepositoryImplementation()
            )
        }
    }
}
