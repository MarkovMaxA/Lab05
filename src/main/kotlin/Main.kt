package main

import commands.*
import main.builders.MovieBuilder
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
            movieManager.addMovie(
                Movie(
                    data[0], Coordinates(data[1].toFloat(), data[2].toDouble()), data[3].toLong(),
                    data[4].toInt(), MovieGenre.valueOf(data[5]), MpaaRating.valueOf(data[6]), Person(
                        data[7],
                        data[8].toInt(), Color.valueOf(data[9]), Country.valueOf(data[10])
                    ), data[11].toLong(),
                    LocalDate.parse(data[12], DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                )
            )
        }
    } catch(e: Exception) {
        ConsoleManager.consolePrint(e.stackTraceToString() + "\n")
    }
    // MovieBuilder().build()
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

