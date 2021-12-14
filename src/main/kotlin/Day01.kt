fun part1(input: List<String>): Int {
    val inputList: List<Int> = input.map { it.toInt() }
    val inputPairs: List<Pair<Int, Int>> = inputList.windowed(2).map { Pair(it[0], it[1]) }
    val increases: List<Boolean> = inputPairs.map { it.second > it.first }
    return increases.count { it }
}

fun part2(input: List<String>): Int {
    val inputList: List<Int> = input.map { it.toInt(2) }
    val windowedInput: List<List<Int>> = inputList.windowed(3)
    val summedWindowedInput: List<Int> = windowedInput.map { it.sum() }

    val inputPairs: List<Pair<Int, Int>> = summedWindowedInput.windowed(2).map { Pair(it[0], it[1]) }
    val increases: List<Boolean> = inputPairs.map { it.second > it.first }
    return increases.count { it }
}



