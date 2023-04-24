package commands

import movies.MovieManager

class ShowCommand(private val movieManager: MovieManager): Command {
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
     * @param arguments if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(vararg arguments: String?): Boolean {
        if (arguments.isNotEmpty()) {
            println("Usage of command help doesn't need any of arguments")
            return false
        }

        val movies = movieManager.getMovieQueue()

        for (movie in movies) {
            println("Movie info: $movie")
        }
        return true
    }
}