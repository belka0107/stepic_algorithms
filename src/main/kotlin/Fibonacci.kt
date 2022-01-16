import java.util.*

fun main(args: Array<String>) {
    val scr = Scanner(System.`in`)
    val n = scr.nextLong()
    val m = scr.nextLong()

    val res = A().fibonacciMod(n, m)
    println("$res")
}

class A {

    fun fibonacci(n: Long): Int {
        var map: MutableMap<Long, Int> = mutableMapOf(0L to 0, 1L to 1)
        if (!map.containsKey(n)) {

            for (i in 2..n) {
                if (!map.containsKey(i)) {
                    val res = fibonacci(i - 1) + fibonacci(i - 2)
                    map[i] = res
                }
            }
        }

        return map[n]!!
    }

    fun fibonacciLastNum(n: Long): Int {
        var prev1 = 0
        var prev2 = 1
        var cur = 0

        for (i in 2..n) {

            cur = (prev1 % 10 + prev2 % 10) % 10

            prev1 = prev2
            prev2 = cur
        }

        return cur
    }

    fun fibonacciMod(n: Long, m : Long): Long {
        var fibPrev = 0L
        var fib = 1L

        var arr = arrayListOf<Long>(fibPrev, fib)

        for ( i in 1..n)
        {
            var fibOld = fib
            fib = (fib + fibPrev) % m
            fibPrev = fibOld
            if (fibPrev == 0L && fib == 1L) {
                arr.removeAt(arr.size - 1)
                break;
            }
            else
                arr.add(fib)
        }
        var offset = (n % arr.size)

        return arr.get(offset.toInt())
    }

}
