package commands

import kotlin.system.exitProcess

class ExitCommand(private val commandManager: CommandManager): Command{
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is shutting down the program without saving\n" +
            "[Command]: exit"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() =  "exit"

    /**
     * Execute command abstract method.
     *
     * @param arguments if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(vararg arguments: String?): Boolean {
        if (arguments.isNotEmpty()) {
            println("Usage of this command doesn't need any of arguments")
            return false
        }

        exitProcess(0)
    }
}
