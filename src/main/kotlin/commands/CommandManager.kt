package commands

import kotlin.collections.HashMap


class CommandManager {
    private val commands = HashMap<String, Command>() // map of commands

    /**
     * get map of commands method
     *
     * @return only readable map of commands [HashMap]
     * @author Markov Maxim 2023
     */
    fun getCommands() = commands.toMap()
}