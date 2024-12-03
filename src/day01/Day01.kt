package day01

import println
import readInput
import kotlin.math.abs

fun main() {


    /**
     * first approach
     */
//    fun part1(input: List<String>): Int {
//        val mappedValues = input.map { it.split("   ") }
//            .map { it[0].toInt() to it[1].toInt() }
//            .unzip()
//
//
//        val listA = mappedValues.first.sorted()
//        val listB = mappedValues.second.sorted()
//
//        return listA.zip(listB).sumOf { (a, b) -> abs(a - b) }
//    }


    /**
     * Try hard mode
     */
    fun part1(input: List<String>): Int =
        input
            .map { ids -> ids.split("   ").let { it[0].toInt() to it[1].toInt() } }
            .unzip()
            .let {
                it.first.sorted() to it.second.sorted()
            }
            .let {
                it.first.zip(it.second).sumOf { (a, b) -> abs(a - b) }
            }

    fun part2(input: List<String>): Int {
        val mappedValues = input.map { it.split("   ") }
            .map { it[0].toInt() to it[1].toInt() }
            .unzip()
        val list = mappedValues.first.map {
            val times = mappedValues.second.count { bValue -> bValue == it}
            times * it
        }
        return list.sumOf { it }
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)
//
//    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day01", "Day01")
    part1(input).println()
    part2(input).println()
}
