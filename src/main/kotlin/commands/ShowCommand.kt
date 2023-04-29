package commands

import movies.MovieManager
import run.ConsoleManager

class ShowCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is showing description of all elements in collection in console\n" +
            "[Command]: show"

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
        if (argument != null) {
            ConsoleManager.consolePrint("Usage of this command doesn't need any of arguments\n")
            return false
        }

        val movies = movieManager.getMovieQueue()

        for (movie in movies) {
            ConsoleManager.consolePrint("Movie info: $movie\n\n")
        }
        return true
    }
}