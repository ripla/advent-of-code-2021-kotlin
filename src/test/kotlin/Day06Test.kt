import Day06.part1
import Day06.part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

private const val TEST_INPUT_NAME = "Day06_test"
private const val INPUT_NAME = "Day06"

internal class Day06Test {

    @Test
    fun part1Test() {
        val testInput = readInput(TEST_INPUT_NAME)

        val testResult1 = part1(testInput)

        println("Solution for part 1 test: $testResult1")

        assertEquals(5934, testResult1)

        val input = readInput(INPUT_NAME)

        val result1 = part1(input)

        println("Solution for part 1: $result1")

        assertEquals(379114, result1)
    }

    @Test
    fun part2Test() {
        val testInput = readInput(TEST_INPUT_NAME)

        val testResult2 = part2(testInput)

        println("Solution for part 2 test: $testResult2")

        assertEquals(26984457539, testResult2)

        val input = readInput(INPUT_NAME)

        val result2 = part2(input)

        println("Solution for part 2: $result2")

        assertEquals(1702631502303, result2)
    }
}