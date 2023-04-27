package commands

import com.opencsv.CSVWriter
import movies.MovieManager
import java.io.File
import java.io.FileWriter

class SaveCommand(private val mg: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is saving collection of movies to csv file\n" +
            "[Command]: save <FileName.csv>"

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
        val filePath=argument
        val file = File(filePath)
        var writer = CSVWriter(FileWriter(file))

        val movies=MovieManager().getMovieQueue()

        writer.writeNext(arrayOf("Id", "OscarsCount"))
        for (movie in movies) {
            val movieValues=arrayOf(movie.getId().toString(), movie.getOscarsCount().toString())
            writer.writeNext(movieValues)
        }

        writer.close()
        return true
    }
}