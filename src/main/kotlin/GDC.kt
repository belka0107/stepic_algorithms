import java.util.*

fun main(args: Array<String>) {
    val scr = Scanner(System.`in`)
    val n = scr.nextLong()
    val m = scr.nextLong()

    val res = GDC().calculate(n, m)
    println("$res")
}

class GDC {

    fun calculate(n: Long, m: Long): Long {
        var arr = arrayListOf<Long>()
        if (n > m) {
            arr.add(n)
            arr.add(m)
        } else {
            arr.add(m)
            arr.add(n)
        }
        var result: Long

        do {
            result = arr[arr.size - 2] % arr[arr.size - 1]
            arr.add(result)
        } while (result != 0L)

        return arr[arr.size - 2]
    }
}