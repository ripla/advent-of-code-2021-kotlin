import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01Test {

    @Test
    fun part1() {
        val testInput = readInput("Day01_test")

        val testResult1 = part1(testInput)

        println("Solution for part 1 test: $testResult1")

        assertEquals(7, testResult1)

        val input = readInput("Day01")

        val result1 = part1(input)

        println("Solution for part 1: $result1")

        assertEquals(1298, result1)
    }

    @Test
    fun part2() {
        val testInput = readInput("Day01_test")

        val testResult2 = part2(testInput)

        println("Solution for part 2 test: $testResult2")

        assertEquals(5, testResult2)

        val input = readInput("Day01")

        val result2 = part2(input)

        println("Solution for part 2: $result2")

        assertEquals(1248, result2)
    }
}