package user_exceptions

import java.io.IOException


/**
 * Input exception representation class
 */
class InputException(private val exceptionInfo: String): IOException(exceptionInfo) {
}

class RecursionScriptException(private val exceptionInfo: String): RuntimeException(exceptionInfo) { }

