package commands

import movies.MovieManager
import user_exceptions.CommandArgumentException

class RemoveLowerCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is removing all the elements, that are less"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "remove_lower"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument == null) throw CommandArgumentException("Method remove_lower don't support zero arguments")

        val oscarsCount = argument.toLong()
        val movies = movieManager.getMovieQueue()
        var id : Long? = null

        for (movie in movies) {
            if (movie.getOscarsCount() < oscarsCount){
                id = movie.getId()
            }
        }

        if (id != null) return movieManager.removeElementById(id)

        return false
    }
}