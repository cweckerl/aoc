package d05

import java.io.File
import java.util.LinkedList

fun main() {

    fun part1(input: List<String>) {
        val (a, b) = input.partition { !Regex("""move \d+ from \d+ to \d+""").matches(it) }
        val crates = mutableMapOf<Int, LinkedList<Char>>()

        a.forEach { line ->
            line.forEachIndexed { i, c ->
                if (c.isLetter()) {
                    val n = (i / 4) + 1
                    crates.getOrPut(n) { LinkedList<Char>() }.addLast(c)
                }
            }
        }

        b.forEach {
            val (n, src, dst) = Regex("""move (\d+) from (\d+) to (\d+)""").find(it)!!.destructured
            (0 until n.toInt()).forEach { _ ->
                val tmp = crates[src.toInt()]!!.removeFirst()
                crates[dst.toInt()]!!.addFirst(tmp)
            }
        }

        crates.toSortedMap().forEach { print(it.value.peekFirst()) }
        print('\n')
    }

    fun part2(input: List<String>) {
        val (a, b) = input.partition { !Regex("""move \d+ from \d+ to \d+""").matches(it) }
        val crates = mutableMapOf<Int, LinkedList<Char>>()

        a.forEach { line ->
            line.forEachIndexed { i, c ->
                if (c.isLetter()) {
                    val n = (i / 4) + 1
                    crates.getOrPut(n) { LinkedList<Char>() }.addLast(c)
                }
            }
        }

        b.forEach {
            val (n, src, dst) = Regex("""move (\d+) from (\d+) to (\d+)""").find(it)!!.destructured
            val crane = LinkedList<Char>()

            (0 until n.toInt()).forEach { _ ->
                val tmp = crates[src.toInt()]!!.removeFirst()
                crane.addFirst(tmp)
            }

            crane.forEach { c -> crates[dst.toInt()]!!.addFirst(c) }
        }

        crates.toSortedMap().forEach { print(it.value.peekFirst()) }
        print('\n')
    }

    val input = File("src/d05/input").readLines()

    part1(input)
    part2(input)
}
