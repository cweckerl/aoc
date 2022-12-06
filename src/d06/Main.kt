package d06

import java.io.File

fun main() {

    fun part1(input: List<String>) {
        for (i in 0..input[0].length - 4) {
            if (input.slice(i..i + 3).toSet().size == 4) {
                println(i + 4)
                return
            }
        }
    }

    fun part2(input: List<String>) {
        for (i in 0..input[0].length - 14) {
            if (input.slice(i..i + 13).toSet().size == 14) {
                println(i + 14)
                return
            }
        }
    }

    val input = File("src/d06/input").readLines()

    part1(input)
    part2(input)
}
