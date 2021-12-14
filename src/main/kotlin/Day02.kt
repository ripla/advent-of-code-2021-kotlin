object Day2 {

    fun part1(input: List<String>): Int {
        data class Position(val horizontal: Int = 0, val depth: Int = 0)
        data class Command(val type: String, val amount: Int)

        val commandList: List<Command> = input.map { it.split(" ") }.map { Command(it[0], it[1].toInt())}
        val resultPosition: Position = commandList.fold(Position()) { acc: Position, elem: Command ->
            val (type, amount) = elem
            when (type) {
                "down" -> acc.copy(depth = acc.depth + amount)
                "up" -> acc.copy(depth = acc.depth - amount)
                "forward" -> acc.copy(horizontal = acc.horizontal + amount)
                else -> acc
            }
        }

        return resultPosition.horizontal * resultPosition.depth
    }

    fun part2(input: List<String>): Int {
        data class Position(val horizontal: Int = 0, val depth: Int = 0, val aim: Int = 0)
        data class Command(val type: String, val amount: Int)

        val commandList: List<Command> = input.map { it.split(" ") }.map { Command(it[0], it[1].toInt())}
        val resultPosition: Position = commandList.fold(Position()) { acc: Position, elem: Command ->
            val (type, amount) = elem
            when (type) {
                "down" -> acc.copy(aim = acc.aim + amount)
                "up" -> acc.copy(aim = acc.aim - amount)
                "forward" -> acc.copy(horizontal = acc.horizontal + amount, depth = acc.depth + acc.aim * amount)
                else -> acc
            }
        }

        return resultPosition.horizontal * resultPosition.depth
    }
}
