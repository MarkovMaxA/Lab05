package run

import commands.Command
import commands.CommandManager
import java.util.Scanner

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
        val sc = Scanner(System.`in`)
        while (sc.hasNext()) {
            val line = sc.next()

            val tokens = line.split(" ")

            if (tokens.isEmpty()) {
                println("Something went wrong:(")
            }
            val command = commandManager.getCommands()[tokens[0]]

            val executionCode = if (tokens.size > 1) commandExecution(command, tokens[1])
            else commandExecution(command, null)

            if (executionCode == ExecutionCode.EXCEPTION) println("Something went wrong:(")
            else if (executionCode == ExecutionCode.NO_COMMAND) println("There's no command $tokens[0]")
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
            return ExecutionCode.EXCEPTION
        }
        return ExecutionCode.EXCEPTION
    }
}