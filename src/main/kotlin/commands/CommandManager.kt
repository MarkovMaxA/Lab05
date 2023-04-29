package commands


class CommandManager {
    private val commands = HashMap<String, Command>() // map of commands

    /**
     * get map of commands method
     *
     * @return only readable map of commands [HashMap]
     * @author Markov Maxim 2023
     */
    fun getCommands() = commands.toMap()

    /**
     * add command to hashmap function
     *
     * @return true if command was added
     * @author Markov Maxim 2023
     */
    fun addCommand(command: Command): Boolean {
        commands[command.getName()] = command
        return true
    }
}