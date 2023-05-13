import commands.*
import movies.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.function.Executable
import run.RunManager
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.test.BeforeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.lang.Exception
class JunitTests {
    val movieManager = MovieManager()
    val commandManager = CommandManager()
    val run = RunManager(commandManager)
    val output = ByteArrayOutputStream()
    val printStream = PrintStream(output)

    @BeforeEach
    fun setUp() {
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

    @DisplayName("first test")
    @Test
    fun testOrganizationValidator() {
        var movie = Movie(
            randomString(),
            Coordinates(Random.nextFloat(), Random.nextDouble()),
            Random.nextLong(),
            Random.nextInt(),
            MovieGenre.ACTION,
            MpaaRating.R,
            Person(randomString(), Random.nextInt(), Color.BLACK, Country.CHINA))

        assertAll(
            Executable { assertThrows(Exception::class.java,) { movie.=0 } },
            Executable { assertThrows(Exception::class.java) { movie.getId()>0 } }
        )
        //    }
        @DisplayName("Second test")
        @Test
        fun secondTest() {

        }
    }
}