package commands


class HelpCommand(private val commandManager: CommandManager): Command {
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
     * @param arguments if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(vararg arguments: String?): Boolean {
        val commands = commandManager.getCommands()

        if (arguments.isNotEmpty()) {
            println("Usage of command help doesn't need any of arguments")
            return false
        }

        for (command in commands.values) {
            println(command.getName() + " - " + command.getDescription())
        }
        return true
    }
}