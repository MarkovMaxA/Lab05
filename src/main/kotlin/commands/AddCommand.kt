package commands

import movies.*
import java.util.Scanner

class AddCommand(private val movieManager: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is showing description of all elements in collection in console\n" +
            "[Command]: show"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "show"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) {
            println("Usage of this command doesn't need any of arguments")
            return false
        }

        val scanner = Scanner(System.`in`)
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

        return movieManager.addMovie(Movie(name, Coordinates(xcoord, ycoord), oscarsCount, lenght, genre, mpaaRating,
            Person(personName, personHeight, personColor, personNationality)))
    }
}