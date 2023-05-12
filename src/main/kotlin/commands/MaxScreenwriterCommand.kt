package commands

import movies.Movie
import movies.MovieManager
import run.ConsoleManager
import user_exceptions.CommandArgumentException

class MaxScreenwriterCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is printing all the elements, which value of screenwriter is maximum"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "max_by_screenwriter"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException("Method max_by_screenwriter don't support arguments")

        val movies = movieManager.getMovieQueue()
        var maxMovie: Movie? = null

        for (movie in movies) {
            if ((maxMovie == null) || (movie.getScreenwriter().getHeight() > maxMovie.getOscarsCount()!!)) {
                maxMovie = movie
            }
        }

        if (maxMovie != null) ConsoleManager.consolePrint("Movie info: $maxMovie\n")
        else ConsoleManager.consolePrint("There's no maximum movie\n")

        return true
    }
}