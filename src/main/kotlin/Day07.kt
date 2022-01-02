import kotlin.math.abs

object Day07 {

    private fun calculateNormalDistance(x: Int, it: Int) = abs(x - it)

    private fun calculateExpandingDistance(x: Int, it: Int): Int {
        val steps = abs(x - it)

        return (1..steps).sum()
    }

    fun part1(input: List<String>): Int {
        val crabs = input.first().split(',').map { it.toInt() }

        val minCrabPosition = crabs.minOrNull()!!
        val maxCrabPosition = crabs.maxOrNull()!!

        val crabDistances = (minCrabPosition..maxCrabPosition)
            .map { potentialPosition -> crabs.sumOf { crabPosition -> calculateNormalDistance(potentialPosition, crabPosition) } }

        return crabDistances.minOrNull()!!
    }

    fun part2(input: List<String>): Int {
        val crabs = input.first().split(',').map { it.toInt() }

        val minCrabPosition = crabs.minOrNull()!!
        val maxCrabPosition = crabs.maxOrNull()!!

        val crabDistances = (minCrabPosition..maxCrabPosition)
            .map { potentialPosition -> crabs.sumOf { crabPosition -> calculateExpandingDistance(potentialPosition, crabPosition) } }

        return crabDistances.minOrNull()!!
    }
}
