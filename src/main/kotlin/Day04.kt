import java.util.regex.Pattern

object Day4 {

    data class BoardCell(val number: Int, val checked: Boolean = false)

    data class BingoBoard(private var rows: List<List<BoardCell>>, private var columns: List<List<BoardCell>>) {

        fun isWinningBoard(): Boolean {
            return hasCompletelyMarkedColumn() || hasCompletelyMarkedRow()
        }

        fun mark(markedNumber: Int) {
            markRow(markedNumber)
            markColumn(markedNumber)
        }

        fun sumOfUnmarked(): Int {
            return rows
                .flatten()
                .filter { !it.checked }
                .sumOf { it.number }
        }

        private fun hasCompletelyMarkedRow(): Boolean {
            return rows.any { row -> row.all { it.checked } }
        }

        private fun hasCompletelyMarkedColumn(): Boolean {
            return columns.any { column -> column.all { it.checked } }
        }

        private fun markRow(checkedNumber: Int) {
            rows = rows.map { row ->
                row.map {
                    if (it.number == checkedNumber) it.copy(checked = true)
                    else it
                }

            }
        }

        private fun markColumn(checkedNumber: Int) {
            columns = columns.map { row ->
                row.map {
                    if (it.number == checkedNumber) it.copy(checked = true)
                    else it
                }
            }
        }
    }

    object BingoParser {
        fun parseInput(input: List<String>): Pair<List<Int>, List<BingoBoard>> {
            val draw: List<Int> = input.first().split(',').map { it.toInt() }

            val boards: List<BingoBoard> = input
                .drop(1)
                .filter { it.isNotBlank() }
                .chunked(5)
                .map { parseBoard(it) }

            return Pair(draw, boards)
        }

        private fun parseBoard(boardInput: List<String>): BingoBoard {
            val numberRows: List<List<Int>> = boardInput
                .map { inputRow -> inputRow.split(" ").filter { it.isNotBlank() }.map { it.toInt() } }

            val rows: List<List<BoardCell>> = numberRows.map { row -> row.map { number -> BoardCell(number) } }

            // transpose
            val columns: List<List<BoardCell>> =
                (0..4)
                    .map { index -> numberRows.map { row -> row[index] } }
                    .map { row -> row.map { BoardCell(it) } }

            return BingoBoard(rows, columns)
        }
    }

    fun part1(input: List<String>): Int {
        val (draw, boards) = BingoParser.parseInput(input)
        for (drawnNumber in draw) {
            boards.forEach { it.mark(drawnNumber) }
            val winningBoard = boards.find { it.isWinningBoard() }
            if (winningBoard != null) {
                return drawnNumber * winningBoard.sumOfUnmarked()
            }
        }

        throw Exception("No winning board found")
    }

    fun part2(input: List<String>): Int {
        var (draw, boards) = BingoParser.parseInput(input)

        for (drawnNumber in draw) {
            boards.forEach { it.mark(drawnNumber) }

            if (boards.size == 1 && boards.first().isWinningBoard()) {
                return drawnNumber * boards.first().sumOfUnmarked()
            }
            boards = boards.filter { !it.isWinningBoard() }
        }

        throw Exception("No winning board found")
    }
}
