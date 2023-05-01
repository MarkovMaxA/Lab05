import movies.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun randomString() = (1..100)
    .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
    .joinToString("")
class MovieExceptionsTest {
    @Test
    fun movieCreationTest() {
        for (i in 1..1000000) {
            try {
                Movie(
                        randomString(),
                        Coordinates(Random.nextFloat(), Random.nextDouble()),
                        Random.nextLong(),
                        Random.nextInt(),
                        MovieGenre.ACTION,
                        MpaaRating.R,
                        Person(randomString(), Random.nextInt(), Color.BLACK, Country.CHINA)
                    )
            } catch (e: Exception) {
                assertEquals(e.javaClass.`package`, user_exceptions.MaxValueException().javaClass.`package`)
            }
        }
    }
}