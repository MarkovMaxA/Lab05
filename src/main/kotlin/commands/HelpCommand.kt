package commands

import run.ConsoleManager
import user_exceptions.CommandArgumentException


class HelpCommand(private val commandManager: CommandManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is printing commands description in console"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() =  "help"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException("Method help don't support arguments")

        val commands = commandManager.getCommands()

        for (command in commands.values) {
            ConsoleManager.consolePrint(command.getName() + " - " + command.getDescription() + "\n\n")
        }
        return true
    }
}