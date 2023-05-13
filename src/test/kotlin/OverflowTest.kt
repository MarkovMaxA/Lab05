import movies.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import user_exceptions.SetOverflowException
import org.junit.jupiter.api.Assertions.*
import user_exceptions.EmptyStringException
import user_exceptions.RecursionScriptException
import kotlin.test.Ignore

class OverflowTest {
    private val movieManager = MovieManager()

    @Test
    fun overflowTesting() {
        Assertions.assertThrows(
            SetOverflowException::class.java
        ) {
                while (true) {
                    movieManager.addMovie(
                        Movie(
                            "randomString()", Coordinates(12f, 13.0), 12,
                            11,
                            MovieGenre.ACTION,
                            MpaaRating.R,
                            Person("randomString()", 14, Color.BLACK, Country.CHINA)
                        )
                    )
            }
        }
    }
}