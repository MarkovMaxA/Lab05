import commands.*
import movies.*
import run.RunManager
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertTrue

class ScriptTest {
    @Test
    fun scriptTest() {
        val movieManager = MovieManager()
        val commandManager = CommandManager()

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

        val run = RunManager(commandManager)

        val output = ByteArrayOutputStream()
        val printStream = PrintStream(output)
        System.setOut(printStream)
        run.runLine("execute_script script.txt")
        assertTrue { output.toString().contains("RecursionScriptException") }
    }
}