class Zeppelin:Aircraft(maxWeight = 1980) {
    override val brand: String = "Zeppelin"

    override val model: String = "MT"

    override val engineCounter: Int = 3
    override val altitude: Int =2600
    override val rows: Int = 1
    override val numberOfSeatsInRow: Int = 12

    override fun getSeatScheme() {
        val seats = seatScheme.first().map {
            if (it == null)
                "_"
            else
                "X"

        }
        val sheme = """
            
        """.trimIndent()
    }

    override val capacity: Int = 12
}