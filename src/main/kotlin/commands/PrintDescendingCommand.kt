package commands

import movies.MovieManager
import user_exceptions.CommandArgumentException

class PrintDescendingCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is printing all the elements descending oscars count value way"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "print_field_descending_oscars_count"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException("Method print_descending don't support arguments")

        val movies = movieManager.getMovieQueue()
        val sortedMovies = movies.sortedBy{it.getOscarsCount() ?: 0}.reversed()
        for (movie in sortedMovies) {
            println(movie.getOscarsCount())
        }
    return true
    }
}