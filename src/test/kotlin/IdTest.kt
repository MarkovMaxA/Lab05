import movies.*
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class IdTest {
    @Test
    fun idTest() {
        val movie1 = Movie(
            "randomString()", Coordinates(12f, 13.0), 12,
            11,
            MovieGenre.ACTION,
            MpaaRating.R,
            Person("randomString()", 14, Color.BLACK, Country.CHINA)
        )
        val movie2 = Movie(
            "randomString()", Coordinates(12f, 13.0), 12,
            11,
            MovieGenre.ACTION,
            MpaaRating.PG,
            Person("randomString()", 14, Color.BLACK, Country.CHINA)
        )
        assertTrue { movie2.getId() > movie1.getId() }
    }
}