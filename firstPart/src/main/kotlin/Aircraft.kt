import java.util.Random

abstract class Aircraft(maxWeight: Int) : Transporter(maxWeight) {
    //Характеристики для всех боингов 737 одинаковые, поэтому они абстракты и будут реализованны в каждой реализации модели самолета
    abstract val brand: String
    abstract val model: String
    abstract val engineCounter: Int
    abstract val altitude: Int

    abstract val rows: Int
    abstract val numberOfSeatsInRow: Int

    //двумерный массив(матрица) рядов и мест
    // by lazy откладывает инициализацию поля, значение поля будет инициализировано при первом обращении этому полю
    protected val seatScheme by lazy {
        List(rows) {
            MutableList<Passenger?>(numberOfSeatsInRow) {
                null
            }
        }
    }


    // эти методы во всех моделях будут реализованы одинаково, поэтому реализуем их в этом классе
    fun addPassenger(passenger: Passenger) { // добавляет пассажира в место
        val row = passenger.seat.row
        val number = passenger.seat.letterUppercase - 'A'
        seatScheme[row][number] = passenger

    }

    fun getPassenger(seat: Seat): Passenger? {//будет возвращать пассажира в указанном месте или null если место не занято
        val row = seat.row
        val number = seat.letterUppercase - 'A'

        return seatScheme[row][number]
    }
fun getAvailableSeat():Seat?{
    val availableSeat = mutableListOf<Seat>()
        seatScheme.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { seatIndex, passenger ->
                if (passenger == null)
                    availableSeat.add(Seat(rowIndex,'A'+ seatIndex))
            }

    }
    return availableSeat.randomOrNull()
}

    abstract fun getSeatScheme()

    fun getInfo() = """ Aircraft - $brand
        |model - $model
        |capacity - $capacity
        |number of rows - $rows
        |number of sets in a row - $numberOfSeatsInRow
    """.trimMargin()


    override fun move() {
        println("Aircraft flying")
    }

}