package d02

import java.io.File

fun main() {

    fun part1(input: List<String>) {
        var total = 0

        input.forEach {
            val opp = it[0]
            val you = it[2]

            total += when (opp) {
                'A' -> when (you) {
                    'X' -> 4
                    'Y' -> 8
                    else -> 3
                }
                'B' -> when (you) {
                    'X' -> 1
                    'Y' -> 5
                    else -> 9
                }
                else -> when (you) {
                    'X' -> 7
                    'Y' -> 2
                    else -> 6
                }
            }
        }

        println(total)
    }

    fun part2(input: List<String>) {
        var total = 0

        input.forEach {
            val opp = it[0]
            val you = it[2]

            total += when (opp) {
                'A' -> when (you) {
                    'X' -> 3
                    'Y' -> 4
                    else -> 8
                }
                'B' -> when (you) {
                    'X' -> 1
                    'Y' -> 5
                    else -> 9
                }
                else -> when (you) {
                    'X' -> 2
                    'Y' -> 6
                    else -> 7
                }
            }
        }

        println(total)
    }

    val input = File("src/d02/input").readLines()

    part1(input)
    part2(input)
}
