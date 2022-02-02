import java.util.*

fun main() {
    val scr = Scanner(System.`in`)
    var qty = scr.nextLong()
    var maxVolume = scr.nextLong().toDouble()

    var weights = mutableListOf<Weight>()

    for (i in 0 until qty) {
        val price = scr.nextLong()
        val volume = scr.nextLong()
        weights.add(Weight(price.toDouble(), volume.toDouble()))
    }

    weights.sortByDescending { it.range }


    var result = mutableListOf<Pair<Double, Double>>()

    for (weight in weights) {
        if (weight.volume <= maxVolume && qty >= 0) {
            result.add(Pair(weight.price, weight.volume))
            maxVolume -= weight.volume
            qty--
        }
        else if(weight.volume > maxVolume && qty >= 0){

            result.add(Pair( weight.range * maxVolume, maxVolume))
            maxVolume = 0.0
            qty--
        }
    }

    var resultPrice = 0.0
    for (res in result) {
        resultPrice += res.first
    }

    println("${"%.3f".format(resultPrice)}")
}

data class Weight(val price: Double, val volume: Double){
    val range : Double = price.div(volume)
}
