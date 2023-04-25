package commands

import movies.*

class PrintAscendingCommand(private val movieManager: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is printing all the elements ascending way\n" +
            "[Command]: print_ascending"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "print_ascending"

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

        val movies = movieManager.getMovieQueue()
        val sortedMovies=movies.sortedWith(compareBy{it.getOscarsCount()})
        println("$sortedMovies")
    return false
    }
}