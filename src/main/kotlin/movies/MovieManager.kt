package movies

import java.util.PriorityQueue

/**
 * Movie manager representative class
 */
class MovieManager {
    private val movieQueue: PriorityQueue<Movie> = PriorityQueue<Movie>()

    /**
     * Get movie queue method
     *
     * @return queue of movies [PriorityQueue]
     * @author Markov Maxim 2023
     */
    fun getMovieQueue(): PriorityQueue<Movie> = movieQueue
}
