package main.builders

import movies.Color
import movies.Country
import movies.Person
import run.ConsoleManager
import user_exceptions.EmptyStringException
import user_exceptions.ValueLessThanZeroException
import java.lang.NumberFormatException

object PersonBuilder: Builder<Person> {
    override fun build() = Person(setName(), setHeight(), setHairColor(), setCountry())


    private fun setName(): String {
        var name: String
        while (true) {
            try {
                ConsoleManager.consolePrint("Input person name: ")

                name = ConsoleManager.getNextLine().trim()
                Person.checkNameRestrictions(name)
                break
            } catch (e: EmptyStringException) {
                ConsoleManager.consolePrint(e.message!! + "\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return name
    }

    private fun setHeight(): Int {
        var height: Int
        while (true) {
            try {
                ConsoleManager.consolePrint("Input person height(type int from 1 to 2147483647): ")

                height = ConsoleManager.getNextLine().trim().toInt()
                Person.checkHeightRestrictions(height)
                break
            } catch (e: NumberFormatException) {
                ConsoleManager.consolePrint("Input data can't be converted to int\n")
            } catch (e: ValueLessThanZeroException) {
                ConsoleManager.consolePrint(e.message!! + "\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return height
    }

    private fun setHairColor(): Color {
        var color: Color

        while (true) {
            try {
                ConsoleManager.consolePrint("Input person hair color from")
                for (colorValue in Color.values()) ConsoleManager.consolePrint(" $colorValue")
                ConsoleManager.consolePrint(": ")

                color = Color.valueOf(ConsoleManager.getNextLine().trim())
                break
            } catch (e: IllegalArgumentException) {
                ConsoleManager.consolePrint("There's no such color\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return color
    }

    private fun setCountry(): Country? {
        var country: Country? = null

        while (true) {
            try {
                ConsoleManager.consolePrint("Input person nationality from")
                for (countryValue in Country.values()) ConsoleManager.consolePrint(" $countryValue")
                ConsoleManager.consolePrint(" or nothing: ")

                val countryString = ConsoleManager.getNextLine().trim()

                if (countryString.isNotEmpty()) country = Country.valueOf(countryString)
                break
            } catch (e: IllegalArgumentException) {
                ConsoleManager.consolePrint("There's no such country\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return country
    }
}