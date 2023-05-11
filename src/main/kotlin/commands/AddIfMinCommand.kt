package commands

import movies.*
import user_exceptions.CommandArgumentException

class AddIfMinCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is adding element, if it's value less then minimum"

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
        if (argument != null) throw CommandArgumentException("Method add_if_min don't support arguments")

        val data = setData()

        val movies = movieManager.getMovieQueue()
        var minValue:Long=12
        for (movie in movies){
            if (movie.getOscarsCount()<minValue){
                minValue=movie.getOscarsCount()
            }
        }
        if (minValue < data.oscarsCount){
            return movieManager.addMovie(Movie(data.name, data.coordinates, data.oscarsCount, data.length, data.genre,
                data.mpaaRating, data.screenWriter))
        }
    return false
    }
}