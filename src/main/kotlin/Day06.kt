object Day06 {

    fun part1(input: List<String>): Int {
        val initialFish: IntArray = input.first().split(',').map { it.toInt() }.toIntArray()

        val fishInTheSea = IntArray(9)

        initialFish.forEach { fishInTheSea[it]++ }

        for (i in 1..80) {
            val newFish = fishInTheSea[0]
            for (j in 1..8) {
                fishInTheSea[j - 1] = fishInTheSea[j]
            }
            fishInTheSea[6] += newFish
            fishInTheSea[8] = newFish
        }

        return fishInTheSea.sum()
    }

    fun part2(input: List<String>): Long {
        val initialFish: List<Int> = input.first().split(',').map { it.toInt() }

        val fishInTheSea = Array<Long>(9) { 0 }

        initialFish.forEach { fishInTheSea[it]++ }

        for (i in 1..256) {
            val newFish = fishInTheSea[0]
            for (j in 1..8) {
                fishInTheSea[j - 1] = fishInTheSea[j]
            }
            fishInTheSea[6] += newFish
            fishInTheSea[8] = newFish
        }

        println(fishInTheSea.joinToString(","))
        return fishInTheSea.sum()
    }
}
