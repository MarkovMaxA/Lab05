package commands

import movies.*
import java.util.*

class UpdateCommand(private val movieManager: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is updating element from collection\n" +
            "[Command]: update <id>"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "update"

    /**
     * Execute command abstract method.
     *
     * @param arguments if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(vararg arguments: String?): Boolean {
        val scanner = Scanner(System.`in`)
        print("Element id: ")

        val id = scanner.nextLong()

        print("Input film name: ")
        val name = scanner.nextLine()
        print("Input coordinates: ")
        print("X: ")
        val xcoord = scanner.nextFloat()
        print("Y: ")
        val ycoord = scanner.nextDouble()
        print("Oscars count: ")
        val oscarsCount = scanner.nextLong()
        print("Length: ")
        val lenght = scanner.nextInt()
        print("Genre: ")
        val genre = MovieGenre.valueOf(scanner.nextLine())
        print("Mpaa rating: ")
        val mpaaRating = MpaaRating.valueOf(scanner.nextLine())
        println("Person:")
        print("Name: ")
        val personName = scanner.nextLine()
        print("Height: ")
        val personHeight = scanner.nextInt()
        print("Hair color: ")
        val personColor = Color.valueOf(scanner.nextLine())
        print("Nationality: ")
        val personNationality = Country.valueOf(scanner.nextLine())

        return movieManager.updateElementById(id, Movie(name, Coordinates(xcoord, ycoord), oscarsCount, lenght, genre,
            mpaaRating, Person(personName, personHeight, personColor, personNationality)))
    }
}