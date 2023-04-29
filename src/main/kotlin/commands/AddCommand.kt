package commands

import movies.*
import run.ConsoleManager

class AddCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is adding new element in collection\n" +
            "[Command]: add"

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
        if (argument != null) {
            ConsoleManager.consolePrint("Usage of this command doesn't need any of arguments\n")
            return false
        }

        val data = setData()

        return movieManager.addMovie(Movie(data.name, data.coordinates, data.oscarsCount, data.length, data.genre,
            data.mpaaRating, data.screenWriter))
    }
}