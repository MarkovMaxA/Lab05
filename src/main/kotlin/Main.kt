
import commands.*
import movies.*
import run.RunManager
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
/**
 * Collection handle function
 *
 * @param args an array of console arguments
 */
fun main(args: Array<String>) {
    val movieManager = MovieManager()
    val commandManager = CommandManager()

    if (args.isEmpty()) {
        val envVar=System.getenv("FILE_PATH") //getting environment variable
        val file = File(envVar)
        val sc = Scanner(file).useDelimiter("\n") //Scanning by lines
        val lines=ArrayList<String>()
        while (sc.hasNext()) {
            lines.add(sc.next().trim()) //reading in array and deliting spaces
        }
        for (line in lines) { //spliting by commas and writing to the collection
            val data=line.split(",")
            movieManager.addMovie(Movie(data[0], Coordinates(data[1].toFloat(), data[2].toDouble()), data[3].toLong(),
                data[4].toInt(), MovieGenre.valueOf(data[5]), MpaaRating.valueOf(data[6]), Person(data[7],
                    data[8].toInt(), Color.valueOf(data[9]), Country.valueOf(data[10])), data[11].toLong(), LocalDate.parse(data[12], DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            ))
        }
    }

    commandManager.addCommand(AddCommand(movieManager))
    commandManager.addCommand(AddIfMaxCommand(movieManager))
    commandManager.addCommand(AddIfMinCommand(movieManager))
    commandManager.addCommand(RemoveByIdCommand(movieManager))
    commandManager.addCommand(ExitCommand())
    commandManager.addCommand(HelpCommand(commandManager))
    commandManager.addCommand(InfoCommand(movieManager))
    commandManager.addCommand(MaxScreenwriterCommand(movieManager))
    commandManager.addCommand(PrintAscendingCommand(movieManager))
    commandManager.addCommand(PrintDescendingCommand(movieManager))
    commandManager.addCommand(RemoveLowerCommand(movieManager))
    commandManager.addCommand(ShowCommand(movieManager))
    commandManager.addCommand(UpdateCommand(movieManager))
    commandManager.addCommand(SaveCommand(movieManager))

    val runManager = RunManager(commandManager)

    runManager.run()
}

