import Day1.part1
import Day1.part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

private const val TEST_INPUT_NAME = "Day01_test"
private const val INPUT_NAME = "Day01"

internal class Day01Test {

    @Test
    fun part1Test() {
        val testInput = readInput(TEST_INPUT_NAME)

        val testResult1 = part1(testInput)

        println("Solution for part 1 test: $testResult1")

        assertEquals(7, testResult1)

        val input = readInput(INPUT_NAME)

        val result1 = part1(input)

        println("Solution for part 1: $result1")

        assertEquals(1298, result1)
    }

    @Test
    fun part2Test() {
        val testInput = readInput(TEST_INPUT_NAME)

        val testResult2 = part2(testInput)

        println("Solution for part 2 test: $testResult2")

        assertEquals(5, testResult2)

        val input = readInput(INPUT_NAME)

        val result2 = part2(input)

        println("Solution for part 2: $result2")

        assertEquals(1248, result2)
    }
}