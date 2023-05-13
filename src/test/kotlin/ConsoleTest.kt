import org.junit.jupiter.api.Test
import run.ConsoleManager
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ConsoleTest {
    @Test
    fun consoleTest() {
        val output = ByteArrayOutputStream()
        val printStream = PrintStream(output)
        System.setOut(printStream)
        for (i in 0..10000) {
            ConsoleManager.consolePrint("randomString()")
        }
    }
}