package d07

import java.io.File

fun main() {
    data class Trie(
        val dir: String,
        val children: MutableMap<String, Trie> = mutableMapOf(),
        val parent: Trie? = null,
        var dirSize: Long = 0L
    )

    // combining parts for this day
    val input = File("src/d07/input").readLines()

    val root = Trie("/")
    var curr = root

    input.drop(1).forEach {
        if (it.startsWith("$ cd")) {
            val dir = it.split(' ')[2]
            curr = if (dir == "..") curr.parent!! else curr.children[dir]!!
        } else if (it.startsWith("dir")) {
            val dir = it.split(' ')[1]
            curr.children[dir] = Trie(dir = "${curr.dir}/$dir", parent = curr)
        } else if (!it.startsWith("$ ls")) {
            curr.dirSize += it.split(' ')[0].toLong()
        }
    }

    val sizes = mutableMapOf<String, Long>()

    fun traverse(root: Trie): Long {
        val tmp = root.dirSize + root.children.values.sumOf { traverse(it) }
        sizes[root.dir] = tmp
        return tmp
    }

    traverse(root)

    println(sizes.values.sumOf { if (it <= 100000) it else 0 }) // part 1
    val total = sizes["/"]!!
    println(sizes.values.filter { 70000000 - total + it >= 30000000 }.min()) // part 2
}
