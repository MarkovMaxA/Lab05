package movies

import java.time.LocalDate
import java.util.*

/**
 * Movie manager representative class
 */
class MovieManager {
    private val movieQueue: HashSet<Movie> = HashSet<Movie>()
    private val creationDate: LocalDate = LocalDate.now()


    /**
     * Get movie queue method
     *
     * @return queue of movies [PriorityQueue]
     * @author Markov Maxim 2023
     */
    fun getMovieQueue() = Collections.unmodifiableSet(movieQueue)

    /**
     * add movie to collection method
     *
     * @argument new element of collection [Movie]
     * @return none.
     * @author Markov Maxim 2023
     */
    fun addMovie(movie: Movie) {
        movieQueue.add(movie)
    }

    /**
     * remove element by id from collection
     *
     * @argument id element id from collection
     * @return true if element was deleted.
     * @author Markov Maxim 2023
     */
    fun removeElementById(id: Long): Boolean {
        for (element in movieQueue) {
            if (element.getId() == id) {
                movieQueue.remove(element)
                return true
            }
        }
        return false
    }

    /**
     * update element by id from collection
     *
     * @argument id element id from collection
     * @return true if element was deleted.
     * @author Markov Maxim 2023
     */
    fun updateElementById(id: Long, movie: Movie): Boolean {
        if (removeElementById(id)) {
            movie.updateId(id)
            addMovie(movie)
            return true
        }

        return false
    }

    /**
     * get collection creation date
     *
     * @return collection creation date [LocalDate]
     * @author Markov Maxim 2023
     */
    fun getCreationDate() = creationDate

    /**
     * get collection class
     *
     * @return class of collection
     * @author Markov Maxim 2023
     */
    fun getCollectionClass() = movieQueue.javaClass

    /**
     * get number of collection elements
     *
     * @return number of elements in collection
     * @author Markov Maxim 2023
     */
    fun getCollectionNumberOfElements() = movieQueue.size
}
