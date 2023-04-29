package commands

import movies.*

class UpdateCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is updating element from collection\n" +
            "[Command]: update <id>"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "update"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument == null) {
            println("Usage of this command needs any of arguments")
            return false
        }

        val id = argument.toLong()

        val data = setData()

        if (movieManager.removeElementById(id)) return movieManager.addMovie(Movie(data.name,
            data.coordinates, data.oscarsCount, data.length, data.genre,
            data.mpaaRating, data.screenWriter, id))
        return false
    }
}