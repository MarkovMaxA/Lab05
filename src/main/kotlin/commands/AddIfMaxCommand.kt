package commands

import movies.*
import user_exceptions.CommandArgumentException

class AddIfMaxCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is adding element, if it's value more then maximum\n" +
            "[Command]: add_if_max"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "add_if_max"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException()

        val data = setData()

        val movies = movieManager.getMovieQueue()
        var maxValue:Long=-1
        for (movie in movies){
            if (movie.getOscarsCount()>maxValue){
                maxValue=movie.getOscarsCount()
            }
        }

        if (maxValue > data.oscarsCount){
            return movieManager.addMovie(Movie(data.name, data.coordinates, data.oscarsCount, data.length, data.genre,
                data.mpaaRating, data.screenWriter))
        }
    return false
    }
}