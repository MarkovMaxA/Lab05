package commands

import movies.MovieManager
import run.ConsoleManager
import user_exceptions.CommandArgumentException

class ShowCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is showing description of all elements in collection in console"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "show"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException("Method show don't support arguments")
        val movies = movieManager.getMovieQueue()

        for (movie in movies) {
            ConsoleManager.consolePrint("Movie info: $movie\n\n")
        }
        return true
    }
}