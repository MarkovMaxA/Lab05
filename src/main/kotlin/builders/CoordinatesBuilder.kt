package main.builders

import movies.Coordinates
import run.ConsoleManager
import user_exceptions.MaxValueException
import java.lang.NumberFormatException

object CoordinatesBuilder: Builder<Coordinates> {
    override fun build() = Coordinates(setX(), setY())


    private fun setX(): Float {
        var x: Float
        while (true) {
            try {
                ConsoleManager.consolePrint("Input X value(float type to 9 significant figures): ")

                val stringX = ConsoleManager.getNextLine().trim()

                x = stringX.toFloat()
                break
            } catch (e: NumberFormatException) {
                ConsoleManager.consolePrint("Input data can't be converted to float")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved exception")
            }
        }
        return x
    }

    private fun setY(): Double {
        var y: Double
        while (true) {
            try {
                ConsoleManager.consolePrint("Input Y value(double type to 18 significant figures): ")

                val stringY = ConsoleManager.getNextLine().trim()

                y = stringY.toDouble()
                Coordinates.checkYRestrictions(y)
                break
            } catch (e: NumberFormatException) {
                ConsoleManager.consolePrint("Input data can't be converted to float\n")
            } catch (e: MaxValueException) {
                ConsoleManager.consolePrint(e.message!! + "\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved exception\n")
            }
        }
        return y
    }
}