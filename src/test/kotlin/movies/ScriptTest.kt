package movies

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class ScriptTest {
    @Test
    fun scriptTest() {
        val outputStream = ByteArrayOutputStream()
        val message = "Hello, world!"
        outputStream.write(message.toByteArray())
    }
}