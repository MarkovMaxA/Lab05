package main

import commands.*
import movies.*
import run.ConsoleManager
import run.RunManager
import java.nio.file.Paths
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Collection handle function
 *
 */
fun main() {
    val movieManager = MovieManager()
    val commandManager = CommandManager()


    try {
        readSet(movieManager)
    } catch (e: Exception) {
        ConsoleManager.consolePrint(e.stackTraceToString() + "\n")
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
    commandManager.addCommand(ExecuteScriptCommand(movieManager))
    val runManager = RunManager(commandManager)

    runManager.run()
}

private fun readSet(movieManager: MovieManager) {
    val envVar = System.getenv("FILE_PATH")

    val lines = ArrayList<String>()
    val scanner = Scanner(Paths.get(envVar))
    scanner.useDelimiter("\n")
    while (scanner.hasNext()) {
        lines.add(scanner.next())
    }
    scanner.close()
    for (line in lines) {
        val data = line.split(",")  // splitting by commas and writing to the collection

        var oscarsCount: Long? = null
        if (data[3].isNotEmpty()) oscarsCount = data[3].toLong()

        var mpaaRating: MpaaRating? = null
        if (data[6].isNotEmpty()) mpaaRating = MpaaRating.valueOf(data[6])

        var country: Country? = null
        if (data[10].isNotEmpty()) country = Country.valueOf(data[10])

        movieManager.addMovie(
            Movie(
                data[0], Coordinates(data[1].toFloat(), data[2].toDouble()), oscarsCount,
                data[4].toInt(), MovieGenre.valueOf(data[5]), mpaaRating,
                Person(
                    data[7],
                    data[8].toInt(),
                    Color.valueOf(data[9]),
                    country
                ),
                data[11].toLong(), LocalDate.parse(data[12], DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            )
        )
    }
}
