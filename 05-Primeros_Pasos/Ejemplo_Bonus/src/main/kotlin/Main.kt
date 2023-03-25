import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            for (i in 1..10) {
                println(i)
                delay(100)
            }
        }
        launch {
            for (i in 1..10) {
                println("--$i")
                delay(200)
            }
        }
    }
}