import movies.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

class RemoveTest {
    private val movieManager = MovieManager()

    @Test
    fun movieCreationTest() {
        for (i in 1..10000) {
            try {
                val rnd = Random.nextInt(0..1)

                if (rnd == 0) {
                    movieManager.addMovie(
                        Movie(
                        randomString(),
                        Coordinates(Random.nextFloat(), Random.nextDouble()),
                        Random.nextLong(),
                        Random.nextInt(),
                        MovieGenre.ACTION,
                        MpaaRating.R,
                        Person(randomString(), Random.nextInt(), Color.BLACK, Country.CHINA)
                    )
                    )
                } else {
                    if (movieManager.getMovieQueue().size > 2) {
                        val max = movieManager.getMovieQueue().maxOf { it.getId() }
                        movieManager.removeElementById(Random.nextLong(1..max))
                    }
                }
            } catch (e: Exception) {
                assertEquals(e.javaClass.`package`, user_exceptions.MaxValueException().javaClass.`package`)
            }
        }
    }


}