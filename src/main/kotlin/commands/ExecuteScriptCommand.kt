package commands

import movies.MovieManager
import run.RunManager
import java.nio.file.Files
import java.nio.file.Paths

class ExecuteScriptCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is executing commands from user's script file\n" +
            "[Command]: execute_script <file>"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "execute_script"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument == null) {
            println("Usage of this command unavailible without arguments")
            return false
        }
        val commandManager = CommandManager()

        val map = hashMapOf<String, Boolean>()

        map[argument] = true

        commandManager.addCommand(AddCommand(movieManager))
        commandManager.addCommand(AddIfMaxCommand(movieManager))
        commandManager.addCommand(AddIfMinCommand(movieManager))
        commandManager.addCommand(RemoveByIdCommand(movieManager))
        commandManager.addCommand(ExitCommand())
        commandManager.addCommand(HelpCommand(commandManager))
        commandManager.addCommand(InfoCommand(movieManager))
        commandManager.addCommand(MaxScreenwriterCommand(movieManager))
        commandManager.addCommand(PrintAscendingCommand(movieManager))
        commandManager.addCommand(PrintDescendingCommand(movieManager))
        commandManager.addCommand(RemoveLowerCommand(movieManager))
        commandManager.addCommand(ShowCommand(movieManager))
        commandManager.addCommand(UpdateCommand(movieManager))
        commandManager.addCommand(SaveCommand(movieManager))
        commandManager.addCommand(ExecuteScriptCommand(movieManager))
        val runManager = RunManager(commandManager)

        val fileName=argument
        val lines= Files.readAllLines(Paths.get(fileName))

        for (line in lines) {
            val tokens = line.split(" ")
            if (tokens[0] == "execute_script") {
                if (map[tokens[1]] == true) {
                    throw user_exceptions.InputException("")
                }
                map[tokens[1]] = true
            }
            runManager.runLine(line)
        }
        return true
    }
}