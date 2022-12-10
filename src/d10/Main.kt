package d10

import java.io.File

fun main() {
    val input = File("src/d10/input").readLines()

    var x = 1
    val signal = mutableListOf(x)

    input.forEach {
        if (it == "noop") {
            signal.add(x)
        } else {
            val n = it.split(' ')[1].toInt()
            repeat(2) { signal.add(x) }
            x += n
        }
    }

    val cycles = listOf(20, 60, 100, 140, 180, 220)

    // part 1
    println(cycles.sumOf { signal[it] * it })

    var line = ""
    var diff = 0

    // part 2
    signal.drop(1).forEachIndexed { i, d ->
        if (i % 40 == 0 && i != 0) {
            println(line)
            diff += 40
            line = ""
        }
        line += if (i - diff in d - 1 .. d + 1) "#" else "."
    }
    println(line)
}
