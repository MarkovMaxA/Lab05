package run

import java.util.*

object ConsoleManager {
    private val scanner = Scanner(System.`in`)

    fun consolePrint(string: String) {
        print(string)
    }

    fun getNextLine(): String = scanner.nextLine()

    fun hasNext() = scanner.hasNext()
}