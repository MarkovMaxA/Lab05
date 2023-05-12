package commands

import main.builders.MovieBuilder
import movies.*
import user_exceptions.CommandArgumentException

class UpdateCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is updating element from collection"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "update"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument == null) throw CommandArgumentException("Method update don't support zero arguments")

        val id = argument.toLong()

        val movie = MovieBuilder.build(id)

        if (movieManager.removeElementById(id)) return movieManager.addMovie(movie)
        return false
    }
}