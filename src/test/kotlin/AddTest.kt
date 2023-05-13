import movies.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

class AddTest {
    private val movieManager = MovieManager()

    @Test
    fun movieCreationTest() {
        movieManager.addMovie(
            Movie(
                "test1",
                Coordinates(Random.nextFloat(), Random.nextDouble()),
                1,
                1,
                MovieGenre.ACTION,
                MpaaRating.R,
                Person("randomString()", 1, Color.BLACK, Country.CHINA))
        )
        val queue= HashSet( movieManager.getMovieQueue())
        movieManager.addMovie(
            Movie(
                "test2",
                Coordinates(Random.nextFloat(), Random.nextDouble()),
                2,
                1,
                MovieGenre.ACTION,
                MpaaRating.R,
                Person("randomString()",1, Color.BLACK, Country.CHINA))
        )
        assertNotEquals(queue,movieManager.getMovieQueue())
        }
    }