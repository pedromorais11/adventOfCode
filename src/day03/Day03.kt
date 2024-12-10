package day03

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int =
        input
            .flatMap { Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(it) }
            .map { it.groupValues.toList().drop(1) }
            .sumOf { it.map(String::toInt).reduce(Int::times) }

    fun part2(input: List<String>): Int =
        input
            .joinToString()
            .split("do()")
            .map { it.substringBefore("don't()") }
            .flatMap {  Regex("mul\\((\\d+),(\\d+)\\)").findAll(it)  }
            .map { it.groupValues.drop(1) }
            .sumOf { it.map(String::toInt).reduce(Int::times) }

    val input = readInput("day03", "Day03")
    part1(input).println()
    part2(input).println()
}