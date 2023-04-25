package commands

import movies.*

class PrintDescendingCommand(private val movieManager: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is printing all the elements descending oscars count value way\n" +
            "[Command]: print_descending"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "print_descending"

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
        val sortedMovies=movies.sortedWith(compareBy{it.getOscarsCount()}).reversed()
        for(movie in sortedMovies){
            println(movie.getOscarsCount())
        }
    return false
    }
}