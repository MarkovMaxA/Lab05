package commands

import run.ConsoleManager


class HelpCommand(private val commandManager: CommandManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is printing commands description in console\n" +
            "[Command]: help"

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
        if (argument != null) {
            ConsoleManager.consolePrint("Usage of this command doesn't need any of arguments\n")
            return false
        }

        val commands = commandManager.getCommands()

        for (command in commands.values) {
            ConsoleManager.consolePrint(command.getName() + " - " + command.getDescription() + "\n")
        }
        return true
    }
}