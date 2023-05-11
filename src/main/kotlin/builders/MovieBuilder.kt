package main.builders

import movies.*
import run.ConsoleManager

/**
 * Movie builder representative class
 */
class MovieBuilder: Builder<Movie> {
    override fun build(): Movie {
        return Movie(getName(), Coordinates(12f, 13.0), 12,
            11,
            MovieGenre.ACTION,
            MpaaRating.R,
            Person(getName(), 14, Color.BLACK, Country.CHINA)
        )
    }

    private fun getName(): String {
        var name: String
        while (true) {
            try {
                ConsoleManager.consolePrint("Input name: ")
                name = ConsoleManager.getNextLine()
                break
            } catch (e: Exception) {
                ConsoleManager.consolePrint(e.stackTraceToString())
            }
        }
        return name
    }
}