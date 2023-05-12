package commands

import main.builders.MovieBuilder
import movies.*
import user_exceptions.CommandArgumentException

class AddIfMaxCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is adding element, if it's value more then maximum"

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
        if (argument != null) throw CommandArgumentException("Method add_if_max don't support arguments")

        val movieToAdd = MovieBuilder.build()

        val movies = movieManager.getMovieQueue()
        var maxValue:Long=-1
        for (movie in movies) {
            val oscarsCount = movie.getOscarsCount() ?: 0

            if ((oscarsCount) > maxValue){
                maxValue = oscarsCount
            }
        }

        if (maxValue > (movieToAdd.getOscarsCount() ?: 0)) {
            return movieManager.addMovie(movieToAdd)
        }
        return false
    }
}