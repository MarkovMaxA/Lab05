package commands

import movies.MovieManager
import run.ConsoleManager
import user_exceptions.CommandArgumentException


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
    override fun getDescription() = "Command is printing collection description in console"

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
        if (argument != null) throw CommandArgumentException("Method info don't support arguments")

        ConsoleManager.consolePrint("Class: " + movieManager.getCollectionClass() + "\n")
        ConsoleManager.consolePrint("Creation date: " + movieManager.getCreationDate() + "\n")
        ConsoleManager.consolePrint("Number of elements: " + movieManager.getCollectionNumberOfElements() + "\n")
        return true
    }
}