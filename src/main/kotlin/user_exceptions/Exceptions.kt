package user_exceptions

import java.io.IOException

/**
 * Input exception representation class
 */
class InputException(private val exceptionInfo: String): IOException(exceptionInfo) {
    /**
     * Get exception info method
     *
     * @return info about exception causes [String]
     * @author Markov Maxim 2023
     */
    fun getInfo(): String = this.exceptionInfo
}