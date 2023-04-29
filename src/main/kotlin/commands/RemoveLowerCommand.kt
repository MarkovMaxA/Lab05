package commands

import movies.MovieManager
import run.ConsoleManager

class RemoveLowerCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is removing all the elements, that are less\n" +
            "[Command]: remove_lower"

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
        if (argument == null) {
            ConsoleManager.consolePrint("Usage of this command needs any of arguments\n")
            return false
        }

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