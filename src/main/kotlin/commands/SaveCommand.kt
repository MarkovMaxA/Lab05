package commands

import movies.MovieManager
import run.ConsoleManager
import user_exceptions.CommandArgumentException
import user_exceptions.NullEnvironmentException
import java.io.File
import java.io.FileWriter

class SaveCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is saving collection of movies to csv file in environment variable"

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
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException("Method save don't support arguments")
        val envVar= System.getenv("FILE_PATH") ?: throw NullEnvironmentException("There's no environment variable with name FILE_PATH")
        val file = File(envVar)
        val writer = FileWriter(file)


        val movies = movieManager.getMovieQueue()
        for (movie in movies) {
            val movieValues = arrayOf(movie.getName(), movie.getCoordinates().getX().toString(),
                movie.getCoordinates().getY().toString(), (movie.getOscarsCount() ?: "").toString(),
                movie.getLength().toString(), movie.getGenre().toString(),(movie.getMpaaRating() ?: "").toString(),
                movie.getScreenwriter().getName(), movie.getScreenwriter().getHeight().toString(),
                movie.getScreenwriter().getHairColor().toString(), movie.getScreenwriter().getNationality().toString(),
                movie.getId().toString(), movie.getCreationDate().toString() )
            writer.write(movieValues.joinToString(",")+"\n")
            ConsoleManager.consolePrint(movieValues.joinToString(",") + "\n")
        }

        writer.close()

        return true
    }
}