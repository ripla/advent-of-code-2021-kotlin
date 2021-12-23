import kotlin.math.abs

object Day05 {

    data class Point(val x: Int, val y: Int)
    data class Line(val start: Point, val end: Point) {
        fun asHVPointList(): List<Point> {
            if (!isHVLine()) {
                throw IllegalStateException("Straight line not possible")

            }

            return if (start.x == end.x) {
                val yPoints = generateValuesBetween(start.y, end.y)
                yPoints.map { Point(start.x, it) }
            } else {
                val xPoints = generateValuesBetween(start.x, end.x)
                xPoints.map { Point(it, start.y) }
            }
        }

        fun asHVDPointList(): List<Point> {
            if (isHVLine()) {
                return asHVPointList()
            }

            val size = abs(start.x - end.x) + 1

            return List(size) { index ->
                Point(generateNextValue(start.x, end.x, index), generateNextValue(start.y, end.y, index))
            }
        }

        fun isHVLine(): Boolean {
            return start.x == end.x || start.y == end.y
        }

        private fun generateValuesBetween(start: Int, end: Int): List<Int> {
            val size = abs(start - end) + 1

            return List(size) { index ->
                generateNextValue(start, end, index)
            }
        }

        private fun generateNextValue(start: Int, end: Int, index: Int) =
            if (start > end) start - index
            else start + index
    }

    private fun parseLines(input: List<String>): List<Line> {
        val linePattern = Regex("(\\d+),(\\d+) -> (\\d+),(\\d+)")
        val result = input.mapNotNull { lineString ->
            val result = linePattern.find(lineString)
            if (result != null) {
                val (x1, y1, x2, y2) = result.destructured
                Line(Point(x1.toInt(), y1.toInt()), Point(x2.toInt(), y2.toInt()))
            } else null
        }

        return result
    }

    fun part1(input: List<String>): Int {
        val lines = parseLines(input)
        val allPoints: List<Point> = lines.filter { it.isHVLine() }.flatMap { it.asHVPointList() }
        val intersectingPoints = allPoints.groupBy { it }

        return intersectingPoints.filterValues { it.size > 1 }.size
    }

    fun part2(input: List<String>): Int {
        val lines = parseLines(input)
        val allPoints: List<Point> = lines.flatMap { it.asHVDPointList() }
        val intersectingPoints = allPoints.groupBy { it }

        return intersectingPoints.filterValues { it.size > 1 }.size
    }
}
