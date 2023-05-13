import movies.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PersonTest {
    @Test
    fun personCreationTest() {
        assertThrows(user_exceptions.ValueLessThanZeroException::class.java,
            {Person("randomString()", -5, Color.BLACK, Country.CHINA)
            })
    }
}