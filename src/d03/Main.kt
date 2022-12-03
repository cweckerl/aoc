package d03

import java.io.File

fun main() {

    fun part1(input: List<String>) {

        val priority = input.sumOf {
            it.substring(0, it.length / 2).toCharArray().toSet()
                .intersect(it.substring(it.length / 2).toCharArray().toSet())
                .sumOf { c -> if (c.isUpperCase()) c.code - 38 else c.code - 96 }
        }

        println(priority)
    }

    fun part2(input: List<String>) {

        val priority = input
            .map { it.toCharArray().toSet() }
            .chunked(3).map { (a, b, c) -> a.intersect(b).intersect(c).first() }
            .sumOf { if (it.isUpperCase()) it.code - 38 else it.code - 96 }

        println(priority)
    }

    val input = File("src/d03/input").readLines()

    part1(input)
    part2(input)
}
