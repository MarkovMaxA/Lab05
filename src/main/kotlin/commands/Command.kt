package commands

import movies.*
import run.ConsoleManager

/**
 * Execution command representative interface
 */
abstract class Command {
    data class MovieData(val name: String, val coordinates: Coordinates,
                         val oscarsCount: Long, val length: Int,
                         val genre: MovieGenre, val mpaaRating: MpaaRating,
                         val screenWriter: Person)

    protected fun setData() : MovieData {
        ConsoleManager.consolePrint("Input film name: ")
        val name = ConsoleManager.getNext()
        ConsoleManager.consolePrint("Input coordinates:\n")
        ConsoleManager.consolePrint("  X: ")
        val xcoord = ConsoleManager.getFloat()
        ConsoleManager.consolePrint("  Y: ")
        val ycoord = ConsoleManager.getDouble()
        ConsoleManager.consolePrint("Oscars count: ")
        val oscarsCount = ConsoleManager.getLong()
        ConsoleManager.consolePrint("Length: ")
        val lenght = ConsoleManager.getInt()
        ConsoleManager.consolePrint("Genre(")
        for (genre in MovieGenre.values()) {
            ConsoleManager.consolePrint("$genre ")
        }
        ConsoleManager.consolePrint("): ")
        val genreString = ConsoleManager.getNext()
        val genre = MovieGenre.valueOf(genreString)
        ConsoleManager.consolePrint("Mpaa rating(")
        for (mpaa in MpaaRating.values()) {
            ConsoleManager.consolePrint("$mpaa ")
        }
        ConsoleManager.consolePrint("): ")
        val mpaaString = ConsoleManager.getNext()
        val mpaaRating = MpaaRating.valueOf(mpaaString)
        ConsoleManager.consolePrint("Person:\n")
        ConsoleManager.consolePrint("  Name: ")
        val personName = ConsoleManager.getNext()
        ConsoleManager.consolePrint("  Height: ")
        val personHeight = ConsoleManager.getInt()
        ConsoleManager.consolePrint("  Hair color(")
        for (color in Color.values()) {
            ConsoleManager.consolePrint("$color ")
        }
        ConsoleManager.consolePrint("): ")
        val colorString = ConsoleManager.getNext()
        val personColor = Color.valueOf(colorString)
        ConsoleManager.consolePrint("  Nationality(")
        for (country in Country.values()) {
            ConsoleManager.consolePrint("$country, ")
        }
        ConsoleManager.consolePrint("): ")
        val nationalityString = ConsoleManager.getNext()
        val personNationality = Country.valueOf(nationalityString)

        return MovieData(name, Coordinates(xcoord, ycoord), oscarsCount, lenght, genre, mpaaRating,
            Person(personName, personHeight, personColor, personNationality))
    }

    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    abstract fun getDescription(): String

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    abstract fun getName(): String


    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    abstract fun execute(argument: String?): Boolean
}