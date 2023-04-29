package commands

import movies.MovieManager
import run.ConsoleManager


/**
 * info command representation class
 */
class InfoCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is printing collection description in console\n" +
            "[Command]: info"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() =  "info"

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

        ConsoleManager.consolePrint("Class: " + movieManager.getCollectionClass() + "\n")
        ConsoleManager.consolePrint("Creation date: " + movieManager.getCreationDate() + "\n")
        ConsoleManager.consolePrint("Number of elements: " + movieManager.getCollectionNumberOfElements() + "\n")
        return true
    }
}