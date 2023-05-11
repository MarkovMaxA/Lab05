package commands

import movies.*
import user_exceptions.CommandArgumentException

class RemoveByIdCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is deleting element from collection"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "remove_by_id"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument == null) throw CommandArgumentException("Method remove_by_id don't support zero arguments")

        val id = argument.toLong()
        return movieManager.removeElementById(id)
    }
}