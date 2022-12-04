package d04

import java.io.File
import kotlin.math.max
import kotlin.math.min

fun main() {

    fun part1(input: List<String>) {

        val total = input.map {
            it.split(',').map { r -> r.split('-').map(String::toInt) }
        }.count { (l, r) ->
            l[0] >= r[0] && l[1] <= r[1] || r[0] >= l[0] && r[1] <= l[1]
        }


        println(total)
    }

    fun part2(input: List<String>) {
        val total = input.map {
            it.split(',').map { r -> r.split('-').map(String::toInt) }
        }.count { (l, r) -> max(l[0], r[0]) <= min(l[1], r[1]) }

        println(total)
    }

    val input = File("src/d04/input").readLines()

    part1(input)
    part2(input)
}
