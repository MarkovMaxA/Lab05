package commands

import movies.MovieManager

class SaveCommand(private val mg: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getInfo(): String {
        return "Command is saving collection of movies to csv file\n [Command]: save <FileName.csv>\n"
    }

    /**
     * Execute command abstract method.
     *
     * @param arguments if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(vararg arguments: String?) {
        // val writer = Files.newBufferedWriter(Paths.get(fileName))

        // val csvPrinter = CSVPrinter(writer, CSVFormat.DEFAULT)
   }
}