package user_exceptions

import java.io.FileNotFoundException


class ScriptNameException() : FileNotFoundException() {}
class SetOverflowException(): ArrayIndexOutOfBoundsException() {}
class CommandArgumentException(): IllegalArgumentException() {}

class ValueLessThanZeroException(): IllegalArgumentException() {}
class MaxValueException(): IllegalArgumentException() {}

class EmptyStringException(): IllegalArgumentException() {}

class RecursionScriptException(): RuntimeException() { }

