import java.util.*
import java.util.stream.Collectors


fun main(args: Array<String>) {
    val scr = Scanner(System.`in`)
    val n = scr.nextLong()

    var segments = mutableListOf<Segment>()

    for (i in 0 until n) {
        val k = scr.nextLong()
        val m = scr.nextLong()
        segments.add(Segment(k, m))
    }

    segments = segments.stream()
        .sorted(Comparator.comparingLong(Segment::end))
        .collect(Collectors.toList());

    val result = SectionPoints().findPoints(segments)

    println(result.size)
    for (r in result)
        print("$r ")
}

class SectionPoints {

    fun findPoints(sections: List<Segment>): List<Long> {
        var result = mutableListOf<Long>()
        for (segment in sections) {
            if (result.size > 0) {
                if (segment.start <= result.get(result.size - 1))
                    continue
                else
                    result.add(segment.end)
            } else
                result.add(segment.end)
        }
        return result
    }
}

data class Segment(val start: Long, val end: Long)
