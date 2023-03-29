import commands.CommandManager
import movies.*
import java.util.function.Predicate

/**
 * Collection handle function
 *
 * @param args an array of console arguments
 */
fun main(args: Array<String>) {
    var k = Movie(name = "Str", coordinates = Coordinates(5.1, 5f), oscarsCount = 1, length = 1, genre = MovieGenre.COMEDY, mpaaRating = MpaaRating.PG_13)
    var k1 = Movie(name = "Str1", coordinates = Coordinates(5.1, 5f), oscarsCount = 1, length = 1, genre = MovieGenre.COMEDY, mpaaRating = MpaaRating.PG_13)

    var person = Person(name = "MMM", hairColor = Color.WHITE)
    var col = person.getHairColor()

    val mg: MovieManager = MovieManager()

    var g = arrayOf(String())

    val commandManager = CommandManager()

}

