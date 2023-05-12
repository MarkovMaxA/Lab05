package main.builders

import movies.*
import run.ConsoleManager
import user_exceptions.EmptyStringException
import user_exceptions.ValueLessThanZeroException
import java.lang.NumberFormatException

/**
 * Movie builder representative class
 */
object MovieBuilder: Builder<Movie> {
    override fun build(): Movie {
        return Movie(setName(),
            CoordinatesBuilder.build(),
            setOscarsCount(),
            setLength(),
            setGenre(),
            setRating(),
            PersonBuilder.build()
        )
    }

    fun build(id: Long): Movie {
        return Movie(setName(),
            CoordinatesBuilder.build(),
            setOscarsCount(),
            setLength(),
            setGenre(),
            setRating(),
            PersonBuilder.build(),
            id
        )
    }

    private fun setName(): String {
        var name: String
        while (true) {
            try {
                ConsoleManager.consolePrint("Input movie name: ")

                name = ConsoleManager.getNextLine().trim()
                Movie.checkNameRestrictions(name)
                break
            } catch (e: EmptyStringException) {
                ConsoleManager.consolePrint(e.message!! + "\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return name
    }

    private fun setOscarsCount(): Long? {
        var oscarsCount: Long? = null
        while (true) {
            try {
                ConsoleManager.consolePrint("Input person height(type int from 1 to 2147483647 or nothing):")

                val stringOscarsCount = ConsoleManager.getNextLine().trim()
                if (stringOscarsCount.isNotEmpty()) oscarsCount = stringOscarsCount.toLong()
                Movie.checkOscarsCountRestrictions(oscarsCount)
                break
            } catch (e: NumberFormatException) {
                ConsoleManager.consolePrint("Input data can't be converted to long\n")
            } catch (e: ValueLessThanZeroException) {
                ConsoleManager.consolePrint(e.message!! + "\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return oscarsCount
    }

    private fun setLength(): Int {
        var length: Int
        while (true) {
            try {
                ConsoleManager.consolePrint("Input movie length(type int from 1 to 2147483647):")

                length = ConsoleManager.getNextLine().trim().toInt()
                Movie.checkLengthRestrictions(length)
                break
            } catch (e: NumberFormatException) {
                ConsoleManager.consolePrint("Input data can't be converted to int\n")
            } catch (e: ValueLessThanZeroException) {
                ConsoleManager.consolePrint(e.message!! + "\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return length
    }

    private fun setGenre(): MovieGenre {
        var genre: MovieGenre

        while (true) {
            try {
                ConsoleManager.consolePrint("Input movie genre from")
                for (genreValue in MovieGenre.values()) ConsoleManager.consolePrint(" $genreValue")
                ConsoleManager.consolePrint(": ")

                genre = MovieGenre.valueOf(ConsoleManager.getNextLine().trim())
                break
            } catch (e: IllegalArgumentException) {
                ConsoleManager.consolePrint("There's no such genre\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return genre
    }

    private fun setRating(): MpaaRating? {
        var rating: MpaaRating? = null

        while (true) {
            try {
                ConsoleManager.consolePrint("Input movie mpaa rating from")
                for (ratingValue in MpaaRating.values()) ConsoleManager.consolePrint(" $ratingValue")
                ConsoleManager.consolePrint(" or nothing: ")

                val ratingString = ConsoleManager.getNextLine().trim()

                if (ratingString.isNotEmpty()) rating = MpaaRating.valueOf(ratingString)
                break
            } catch (e: IllegalArgumentException) {
                ConsoleManager.consolePrint("There's no such rating\n")
            } catch (e: Exception) {
                ConsoleManager.consolePrint("Unresolved error\n")
            }
        }
        return rating
    }
}