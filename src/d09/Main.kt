package d09

import java.io.File
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {

    fun dist(p1: Pair<Int, Int>, p2: Pair<Int, Int>) = sqrt(
        (p1.first - p2.first).toDouble().pow(2) +
                (p1.second - p2.second).toDouble().pow(2)
    )

    fun part1(input: List<String>) {
        var h = Pair(0, 0)
        var t = Pair(0, 0)
        var prev = Pair(0, 0)
        val visited = mutableSetOf<Pair<Int, Int>>()
        visited.add(prev)

        input.forEach {
            val (d, m) = it.split(' ')

            // dist, mag
            repeat(m.toInt()) {
                prev = h

                h = when (d) {
                    "U" -> h.copy(second = h.second + 1)
                    "D" -> h.copy(second = h.second - 1)
                    "L" -> h.copy(first = h.first - 1)
                    else -> h.copy(first = h.first + 1)
                }

                if (dist(h, t) > sqrt(2.0)) {
                    t = prev.copy()
                    visited.add(t)
                }
            }
        }

        println(visited.size)
    }

    fun part2(input: List<String>) {
        val p = MutableList(10) { Pair(0, 0) }
        var prev = Pair(0, 0)
        val visited = mutableSetOf<Pair<Int, Int>>()
        visited.add(prev)

        input.forEach { line ->
            val (d, m) = line.split(' ')

            repeat(m.toInt()) {
                prev = p[0]

                p[0] = when (d) {
                    "U" -> p[0].copy(second = p[0].second + 1)
                    "D" -> p[0].copy(second = p[0].second - 1)
                    "L" -> p[0].copy(first = p[0].first - 1)
                    else -> p[0].copy(first = p[0].first + 1)
                }

                for (i in 0 until p.size - 1) {
                    if (dist(p[i], p[i + 1]) > sqrt(2.0)) {
                        val dx = prev.first - p[1].first
                        val dy = prev.second - p[1].second

                        val indices = mutableSetOf(1)

                        for (j in i + 1 until p.size - 1) {
                            if (dist(p[j], p[j + 1]) != 1.0) {
                                break
                            }
                            indices.add(j + 1)
                        }

                        indices.forEach { p[it] = p[it].copy(p[it].first + dx, p[it].second + dy) }
                        visited.add(p.last())
                    }
                }
            }
        }

        println(visited.size)
    }

    val input = File("src/d09/input").readLines()

    part1(input)
    part2(input)
}