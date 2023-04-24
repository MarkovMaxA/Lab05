package commands

import movies.*
import java.util.*

class DeleteCommand(private val movieManager: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is deleting element from collection\n" +
            "[Command]: update <id>"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "delete"

    /**
     * Execute command abstract method.
     *
     * @param arguments if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(vararg arguments: String?): Boolean {
        val scanner = Scanner(System.`in`)
        print("Element id: ")

        val id = scanner.nextLong()

        return movieManager.removeElementById(id)
    }
}