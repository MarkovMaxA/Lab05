import movies.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import user_exceptions.EmptyStringException

class NameTest {
    @Test
    fun nameTest() {
        Assertions.assertThrows(
            EmptyStringException::class.java
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
