package d01

import java.io.File
import java.util.PriorityQueue

fun main() {
    val input = File("src/d01/input").readLines()
    val pq = PriorityQueue<Int>()
    var tmp = 0

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

    println(pq.last()) // part 1
    println(pq.sum()) // part 2
}
