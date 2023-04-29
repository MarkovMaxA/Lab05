package commands

import user_exceptions.CommandArgumentException
import kotlin.system.exitProcess

class ExitCommand: Command() {
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
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException()

        exitProcess(0)
    }
}
