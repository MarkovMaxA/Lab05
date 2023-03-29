package commands

/**
 * Execution command representative interface
 */
interface Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    fun getInfo(): String

    /**
     * Execute command abstract method.
     *
     * @param arguments if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    fun execute(vararg arguments: String?)
}