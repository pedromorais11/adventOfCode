package day02

import println
import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val abc = input.map {
            val values = it.split(" ").map(String::toInt)
            if (values.first() < values.last()) {
                values.mapIndexed { index, value ->
                    if (index + 1 < values.size) {
                        value.takeIf { (values[index + 1] - value) in 1..3 }?.let { 1 } ?: 0
                    } else { 1 }
                }
            } else {
                values.mapIndexed { index, value ->
                    if (index + 1 < values.size) {
                        value.takeIf { (value - values[index + 1]) in 1..3 }?.let { 1 } ?: 0
                    } else { 1 }
                }
            }
        }
        return abc.count { !it.contains(0) }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day02", "Day02")
    part1(input).println()
    part2(input).println()
}