import movies.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MovieExceptionsTest {
    @Test
    fun oscarsTest() {
        assertThrows(user_exceptions.ValueLessThanZeroException::class.java
        ) {
            Movie(
                "dsads",
                Coordinates(45f, 45.0),
                -5,
                3,
                MovieGenre.ACTION,
                MpaaRating.R,
                Person("dsadsa", 34, Color.BLACK, Country.CHINA)
            )
        }
    }

    @Test
    fun nameTest() {
        assertThrows(user_exceptions.EmptyStringException::class.java
        ) {
            Movie(
                "",
                Coordinates(45f, 45.0),
                3,
                3,
                MovieGenre.ACTION,
                MpaaRating.R,
                Person("dsadsa", 34, Color.BLACK, Country.CHINA)
            )
        }
    }
}