import movies.*
import org.junit.jupiter.api.Test
import user_exceptions.SetOverflowException
import org.junit.jupiter.api.Assertions.*

class OverflowTest {
    private val movieManager = MovieManager()

    @Test
    fun overflowTesting() {
        while (true) {
            try {
                movieManager.addMovie(
                    Movie(
                        randomString(), Coordinates(12f, 13.0), 12,
                        11,
                        MovieGenre.ACTION,
                        MpaaRating.R,
                        Person(randomString(), 14, Color.BLACK, Country.CHINA)
                    )
                )
            } catch (e: Exception) {
                assertEquals(e.javaClass, SetOverflowException("писька").javaClass)
                break
            }
        }
    }
}