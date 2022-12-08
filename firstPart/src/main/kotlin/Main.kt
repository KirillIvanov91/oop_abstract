import kotlin.random.Random

fun main() {
val boeing737:Boeing737 = Boeing737()
    val passengerCount :Int = Random.nextInt(1,boeing737.capacity)
    for (i in 0 until passengerCount){
        val seat = boeing737.getAvailableSeat()?: return
        val passenger = Passenger("Alex",
            "Lisinski",
            "${Random.nextInt(1000,5000)} ${Random.nextInt(100000,500000)}",
            seat = seat)

        boeing737.addPassenger(passenger)
    }
    println(boeing737.getInfo())
    boeing737.getSeatScheme()

}