package commands

import movies.MovieManager

class SaveCommand(private val mg: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Markov Maxim 2023
     */
    override fun getDescription() = "Command is saving collection of movies to csv file\n" +
            "[Command]: save <FileName.csv>"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Markov Maxim 2023
     */
    override fun getName() = "save"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Markov Maxim 2023
     */
    override fun execute(argument: String?): Boolean {
        // val writer = Files.newBufferedWriter(Paths.get(fileName))

        // val csvPrinter = CSVPrinter(writer, CSVFormat.DEFAULT)
        return true
   }
}