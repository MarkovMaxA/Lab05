import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import run.ConsoleManager
import user_exceptions.EmptyStringException
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ConsoleTest {
    @Test
    fun consoleTest() {
        val output = ByteArrayOutputStream()
        val printStream = PrintStream(output)
        System.setOut(printStream)
        Assertions.assertDoesNotThrow(
        ) {
            ConsoleManager.consolePrint("command")
    }
}}
