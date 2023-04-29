package commands

import movies.MovieManager
import run.ConsoleManager
import java.io.File
import java.io.FileWriter
import java.util.*

class SaveCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is saving collection of movies to csv file in environment variable\n" +
            "[Command]: save"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "save"

    /**
     * Execute command abstract method.
     *
     * @param arguments if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) {
            ConsoleManager.consolePrint("Usage of this command doesn't need any of arguments\n")
            return false
        }
        val envVar=System.getenv("FILE_PATH")
        val file = File(envVar)
        val writer = FileWriter(file)


        val movies = movieManager.getMovieQueue()
        for (movie in movies) {
            val movieValues=arrayOf(movie.getName(), movie.getCoordinates().getX().toString(),
                movie.getCoordinates().getY().toString(),movie.getOscarsCount().toString(),
                movie.getLength().toString(),movie.getGenre().toString(),movie.getMpaaRating().toString(),
                movie.getScreenwriter().getName(),movie.getScreenwriter().getHeight().toString(),
                movie.getScreenwriter().getHairColor().toString(),movie.getScreenwriter().getNationality().toString(),
                movie.getId().toString(),movie.getCreationDate().toString() )
            writer.write(movieValues.joinToString(",")+"\n")
            ConsoleManager.consolePrint(movieValues.joinToString(",") + "\n")
        }

        writer.close()

        return true
    }
}