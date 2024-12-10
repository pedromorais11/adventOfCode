package day04

import println
import readInput

fun main() {

    fun getChar(input: List<String>, row: Int, col: Int): Char {
        return try {
            input[row][col]
        } catch (ex: IndexOutOfBoundsException) {
            'F'
        }
    }

    fun part1(input: List<String>): Int {
        return input
            .asSequence()
            .mapIndexed { row, chars ->
                chars.mapIndexed { col, char ->
                    if (char == 'X') {
                        val upper = "$char${getChar(input,row - 1, col)}${getChar(input,row - 2, col)}${getChar(input,row - 3, col)}"
                        val bottom = "$char${getChar(input,row + 1, col)}${getChar(input,row + 2, col)}${getChar(input,row + 3, col)}"
                        val right = "$char${getChar(input,row, col + 1)}${getChar(input,row, col + 2)}${getChar(input,row, col + 3)}"
                        val left = "$char${getChar(input,row, col - 1)}${getChar(input,row, col - 2)}${getChar(input,row, col - 3)}"

                        val upperRight = "$char${getChar(input,row - 1, col + 1)}${getChar(input,row - 2, col + 2)}${getChar(input,row - 3, col + 3)}"
                        val upperLeft = "$char${getChar(input,row - 1, col - 1)}${getChar(input,row - 2, col - 2)}${getChar(input,row - 3, col - 3)}"
                        val bottomRight = "$char${getChar(input,row + 1, col + 1)}${getChar(input,row + 2, col + 2)}${getChar(input,row + 3, col + 3)}"
                        val bottomLeft = "$char${getChar(input,row + 1, col - 1)}${getChar(input,row + 2, col - 2)}${getChar(input,row + 3, col - 3)}"

                        listOf(upper, bottom, right, left, upperRight, upperLeft, bottomRight, bottomLeft)
                    } else {
                        emptyList()
                    }
                }
            }
            .flatten()
            .filter { it.isNotEmpty() }
            .flatten()
            .count { it == "XMAS" }
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        input
            .asSequence()
            .forEachIndexed { row, chars ->
                chars.forEachIndexed { col, _ ->
                    val searchBox = listOf(
                        listOf(getChar(input, row, col), getChar(input, row, col+1), getChar(input, row, col+2)),
                        listOf(getChar(input, row+1, col), getChar(input, row+1, col+1), getChar(input, row+1, col+2)),
                        listOf(getChar(input, row+2, col), getChar(input, row+2, col+1), getChar(input, row+2, col+2)),
                    )
                    val diagonal1 = "${searchBox[0][0]}${searchBox[1][1]}${searchBox[2][2]}"
                    val diagonal2 = "${searchBox[2][0]}${searchBox[1][1]}${searchBox[0][2]}"

                    if (diagonal1 == "MAS" || diagonal2 == "MAS" || diagonal1 == "SAM" || diagonal2 == "SAM") {
                        if(diagonal1 == diagonal2 || diagonal1.toCharArray().sorted() == diagonal2.toCharArray().sorted()) {
                            counter++
                        }
                    }
                }
            }
        return counter
    }

    val input = readInput("day04", "Day04")
    part1(input).println()
    part2(input).println()
}