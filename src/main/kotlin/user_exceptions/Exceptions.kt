package user_exceptions

import java.io.FileNotFoundException


class ScriptNameException(string: String) : FileNotFoundException(string) {}
class SetOverflowException(string: String): ArrayIndexOutOfBoundsException(string) {}
class CommandArgumentException(string: String): IllegalArgumentException(string) {}
class ValueLessThanZeroException(string: String): IllegalArgumentException(string) {}
class MaxValueException(string: String): IllegalArgumentException(string) {}
class EmptyStringException(string: String): IllegalArgumentException(string) {}
class RecursionScriptException(string: String): RuntimeException(string) { }
class NullEnvironmentException(string: String): IllegalArgumentException(string) {}