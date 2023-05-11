import movies.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import user_exceptions.MaxValueException
import kotlin.random.Random

class CoordsTest {
    @Test
    fun coordsCreationTest() {
        for (i in 1..1000000) {
            try {
                Coordinates(Random.nextFloat(), Random.nextDouble())
            } catch (e: Exception) {
                Assertions.assertEquals(e.javaClass.`package`, MaxValueException("dsa").javaClass.`package`)
            }
        }
    }
}
