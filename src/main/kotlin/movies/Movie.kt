package movies

import user_exceptions.InputException
import java.time.LocalDate

/**
 * Person representation class
 */
class Person(private val name: String, private val height: Float? = null,
             private val hairColor: Color? = null, private val nationality: Country? = null) {
    init {
        if (name.isEmpty())
            throw InputException("Name couldn't be zero length")
        if (height != null && height <= 0)
            throw InputException("Height couldn't be less than zero")
    }

    /**
     * Name getter method
     *
     * @return person name [String]
     * @author Markov Maxim 2023
     */
    fun getName() = this.name

    /**
     * Height getter method
     *
     * @return person height [Float]
     * @author Markov Maxim 2023
     */
    fun getHeight() = this.height

    /**
     * Hair color getter method
     *
     * @return person hair color [Color]
     * @author Markov Maxim 2023
     */
    fun getHairColor() = this.hairColor

    /**
     * Nationality getter method
     *
     * @return person nationality [Country]
     * @author Markov Maxim 2023
     */
    fun getNationality() = this.nationality
}

class Coordinates(private val x: Double, private val y: Float) {
    init {
        if (x <= -513)
            throw InputException("X must be more than -513")
        if (y > 424)
            throw InputException("Y must be less or equal 424")
    }

    /**
     * X getter method
     *
     * @return x coordinate [Double]
     * @author Markov Maxim 2023
     */
    fun getX() = this.x

    /**
     * Y getter method
     *
     * @return y coordinate [Float]
     * @author Markov Maxim 2023
     */
    fun getY() = this.y
}

class Movie(private var name: String, private var coordinates: Coordinates,
            private var oscarsCount: Int, private var length: Long,
            private var genre: MovieGenre, private var mpaaRating: MpaaRating
) {
    private var id: Long = giveId()
    private var creationDate: LocalDate = LocalDate.now()

    init {
        if (name.isEmpty())
            throw InputException("Name couldn't be empty")
        if (oscarsCount < 1)
            throw InputException("Oscars couldn't be less than zero")
        if (length < 1)
            throw InputException("Length couldn't be less than zero")
    }

    private companion object {
        var cntId: Long = 0

        /**
         * Giving id to movie instance method
         *
         * @return id of new movie [Long]
         */
        @JvmStatic
        fun giveId(): Long {
            cntId += 1
            return cntId
        }
    }

    /**
     * Name getter method
     *
     * @return movie name [String]
     * @author Markov Maxim 2023
     */
    fun getName() = this.name

    /**
     * Coordinates getter method
     *
     * @return movie coordinates [Coordinates]
     * @author Markov Maxim 2023
     */
    fun getCoordinates() = this.coordinates

    /**
     * Oscars count getter method
     *
     * @return movie oscars count [Int]
     * @author Markov Maxim 2023
     */
    fun getOscarsCount() = this.oscarsCount

    /**
     * Length getter method
     *
     * @return movie length [Long]
     * @author Markov Maxim 2023
     */
    fun getLength() = this.length

    /**
     * Genre getter method
     *
     * @return movie genre [MovieGenre]
     * @author Markov Maxim 2023
     */
    fun getGenre() = this.genre

    /**
     * Mpaa rating getter method
     *
     * @return movie mpaa rating [mpaaRating]
     * @author Markov Maxim 2023
     */
    fun getMpaaRating() = this.mpaaRating

    /**
     * Id getter method
     *
     * @return movie id [Long]
     * @author Markov Maxim 2023
     */
    fun getId() = this.id

    /**
     * Creation date getter method
     *
     * @return movie creation date [LocalDate]
     * @author Markov Maxim 2023
     */
    fun getCreationDate() = this.creationDate
}

