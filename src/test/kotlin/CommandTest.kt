import commands.*
import movies.MovieManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import run.RunManager
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.test.BeforeTest


class CommandTest {
    val movieManager = MovieManager()
    val commandManager = CommandManager()
    val run = RunManager(commandManager)

    @BeforeTest
    fun setUp(){
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


    }
    @Test
    fun commandTest() {
        val output = ByteArrayOutputStream()
        val printStream = PrintStream(output)
        System.setOut(printStream)
        val commands = listOf("show", "help", "info", "print_ascending", "print_descending")

        for (i in 0..10000) {
            run.runLine(commands[Random.nextInt(commands.indices)])
        }


    }
}