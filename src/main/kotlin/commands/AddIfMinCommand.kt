package commands

import movies.*
import java.util.Scanner

class AddIfMinCommand(private val movieManager: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is adding element, if it's value less then minimum\n" +
            "[Command]: add_if_min"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "add_if_min"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) {
            println("Usage of this command doesn't need any of arguments")
            return false
        }

        val scanner = Scanner(System.`in`)
        print("Input film name: ")
        val name = scanner.next()
        println("Input coordinates: ")
        print("  X: ")
        val xcoord = scanner.nextFloat()
        print("  Y: ")
        val ycoord = scanner.nextDouble()
        print("Oscars count: ")
        val oscarsCount = scanner.nextLong()
        print("Length: ")
        val lenght = scanner.nextInt()
        print("Genre: ")
        val genreString = scanner.next()
        val genre = MovieGenre.valueOf(genreString)
        print("Mpaa rating: ")
        val mpaaString = scanner.next()
        val mpaaRating = MpaaRating.valueOf(mpaaString)
        println("Person:")
        print("  Name: ")
        val personName = scanner.next()
        print("  Height: ")
        val personHeight = scanner.nextInt()
        print("  Hair color: ")
        val colorString = scanner.next()
        val personColor = Color.valueOf(colorString)
        print("  Nationality: ")
        val nationalityString = scanner.next()
        val personNationality = Country.valueOf(nationalityString)

        val movies = movieManager.getMovieQueue()
        var minValue:Long=12
        for (movie in movies){
            if (movie.getOscarsCount()<minValue){
                minValue=movie.getOscarsCount()
            }
        }
        if (minValue<oscarsCount){
            return movieManager.addMovie(Movie(name, Coordinates(xcoord, ycoord), oscarsCount, lenght, genre, mpaaRating,
                Person(personName, personHeight, personColor, personNationality)))
        }
    return false
    }
}