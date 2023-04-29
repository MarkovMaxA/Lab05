package run

import commands.Command
import commands.CommandManager

/**
 * Command execution code
 */
enum class ExecutionCode {
    COMPLETED,
    NO_COMMAND,
    EXCEPTION
}

/**
 * Progrum runtime representative class
 */
class RunManager(private val commandManager: CommandManager) {
    /**
     * run method
     *
     * @author Markov Maxim 2023S
     */
    fun run() {
        while (ConsoleManager.hasNext()) {
            val line = ConsoleManager.getNextLine()

            val tokens = line.split(" ")

            val command = commandManager.getCommands()[tokens[0]]

            val executionCode = if (tokens.size > 1) commandExecution(command, tokens[1])
            else commandExecution(command, null)

            if (executionCode == ExecutionCode.EXCEPTION) ConsoleManager.consolePrint("Something went wrong:((\n")
            else if (executionCode == ExecutionCode.NO_COMMAND) ConsoleManager.consolePrint("There's no command ${tokens[0]}\n")
        }
    }

    /**
     * command execution method
     *
     * @argument command to execute [Command]
     * @author Markov Maxim 2023
     */
    private fun commandExecution(command: Command?, argument: String?): ExecutionCode {
        if (command == null) {
            return ExecutionCode.NO_COMMAND
        }
        try {
            if (command.execute(argument)) return ExecutionCode.COMPLETED
        } catch (e: Exception) {
            ConsoleManager.consolePrint(e.javaClass.simpleName + "\n")
            return ExecutionCode.EXCEPTION
        }
        return ExecutionCode.EXCEPTION
    }
}