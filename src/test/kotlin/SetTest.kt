import movies.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SetTest {
    private val movieManager = MovieManager()

    @Test
    fun setTest() {
        val movie = Movie(
            "randomString()", Coordinates(12f, 13.0), 12,
            11,
            MovieGenre.ACTION,
            MpaaRating.R,
            Person("randomString()", 14, Color.BLACK, Country.CHINA)
        )
        movieManager.addMovie(movie)
        movieManager.addMovie(movie)
        assertEquals(movieManager.getMovieQueue().size, 1)
    }
}