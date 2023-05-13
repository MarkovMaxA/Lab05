import movies.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import user_exceptions.MaxValueException
import kotlin.random.Random

class PersonTest {
    @Test
    fun personCreationTest() {
        for (i in 1..1000000) {
            try {
                Person("randomString()", Random.nextInt(), Color.BLACK, Country.CHINA)
            } catch (e: Exception) {
                Assertions.assertEquals(e.javaClass.`package`, MaxValueException("dsadsa").javaClass.`package`)
            }
        }
   }
}
