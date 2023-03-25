import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            delay(1000)
            print("Mundo!")
        }
        launch {
            delay(100)
            print("Hola ")
        }
    }
}