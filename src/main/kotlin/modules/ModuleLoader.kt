package modules

object ModuleLoader {

    fun loadModule(){

        val dbModule = DbModule.create()
        val serviceModule = ServiceModule.create(dbModule)
        val controllerModule = ControllerModule.create(serviceModule)
    }
}