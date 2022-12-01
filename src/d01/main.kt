package d01

import java.io.File
import java.util.PriorityQueue

fun main() {
    val input = File("src/d01/input").readLines()

    // part 1
    var max = -1
    var tmp = 0

    input.forEach {
        if (it.isBlank()) {
            if (tmp > max) {
                max = tmp
            }
            tmp = 0
        } else {
            tmp += it.toInt()
        }
    }

    println(max)

    // part 2
    val pq = PriorityQueue<Int>()
    tmp = 0

    input.forEach {
        if (it.isBlank()) {
            pq.add(tmp)
            if (pq.size > 3) {
                pq.poll()
            }
            tmp = 0
        } else {
            tmp += it.toInt()
        }
    }

    println(pq.reversed().sum())
}
