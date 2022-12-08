package d08

import java.io.File

fun main() {

    fun part1(input: List<String>) {
        var trees = 0
        val visited = mutableMapOf<Int, Char>()

        for (i in input.indices) {
            for (j in input[0].indices) {
                if (i == 0 || i == input.size - 1 || j == 0 || j == input[0].length - 1) {
                    if (i == 0) visited[j] = input[i][j]
                    trees++
                } else {
                    val tree = input[i][j]
                    val left = input[i].substring(0, j)
                    val right = input[i].substring(j + 1)

                    if (tree > visited[j]!!) {
                        trees++
                        visited[j] = tree
                    } else if (tree > left.max() || tree > right.max() || tree > input.drop(i + 1).maxOf { it[j] }) {
                        trees++
                    }
                }
            }
        }
        println(trees)
    }

    fun part2(input: List<String>) {
        var score = 0

        for (i in input.indices) {
            for (j in input[0].indices) {
                if (!(i == 0 || i == input.size - 1 || j == 0 || j == input[0].length - 1)) {
                    val tree = input[i][j]
                    val left = input[i].substring(0, j).reversed().toList()
                    val right = input[i].substring(j + 1).toList()
                    val up = input.subList(0, i).reversed().map { it[j] }
                    val down = input.drop(i + 1).map { it[j] }

                    val paths = arrayOf(up, down, left, right)

                    val tmp = paths.map {
                        var count = 0
                        for (t in it) {
                            count++
                            if (tree <= t) break
                        }
                        count
                    }.reduce(Int::times)

                    if (tmp > score) score = tmp
                }
            }
        }
        println(score)
    }

    val input = File("src/d08/input").readLines()

    part1(input)
    part2(input)
}
