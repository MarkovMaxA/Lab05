package run

import java.util.*

object ConsoleManager {
    private val scanner = Scanner(System.`in`)

    fun consolePrint(string: String) {
        print(string)
    }

    fun getInt() = scanner.nextInt()
    fun getLong() = scanner.nextLong()
    fun getFloat() = scanner.nextFloat()
    fun getNext() = scanner.next()

    fun getNextLine() = scanner.nextLine()

    fun hasNext() = scanner.hasNext()
    fun getDouble() = scanner.nextDouble()
}