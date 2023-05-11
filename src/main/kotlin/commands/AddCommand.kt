package commands

import movies.*
import user_exceptions.CommandArgumentException

class AddCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is adding new element in collections"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "add"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException("Method add don't support arguments")

        val data = setData()

        return movieManager.addMovie(Movie(data.name, data.coordinates, data.oscarsCount, data.length, data.genre,
            data.mpaaRating, data.screenWriter))
    }
}