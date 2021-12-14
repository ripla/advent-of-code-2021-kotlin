object Day3 {

    fun part1(input: List<String>): Int {
        val inputLineLength = input.first().length
        val startingList = MutableList(inputLineLength) { 0 }

        val onesCount: List<Int> = input.fold(startingList) { acc, number ->
            val numberList = number.toList()
            for (i in numberList.indices) {
                acc[i] = acc[i] + Character.getNumericValue(numberList[i])
            }
            acc
        }

        val gammaRateList = List(inputLineLength) { i ->
            val zeroesCount = input.size - onesCount[i]
            if (onesCount[i] >= zeroesCount)
                1
            else
                0
        }

        val gammaRateString = gammaRateList.joinToString(separator = "")
        val gammaRate = gammaRateString.toInt(2)

        val epsilonRateString = gammaRateList.map { if (it == 1) '0' else '1' }.joinToString(separator = "")
        val epsilonRate = epsilonRateString.toInt(2)

        return gammaRate * epsilonRate
    }

    fun part2(input: List<String>): Int {
        val isOneMostCommon = { inputList: List<String>, index: Int ->
            val onesCount: Int = inputList.fold(0) { acc, binary ->
                acc + binary[index].toString().toInt()
            }

            val zeroesCount = inputList.size - onesCount
            onesCount >= zeroesCount
        }

        var oxygenGeneratorRating = input
        var index = 0
        while (oxygenGeneratorRating.size > 1) {
            val commonBinary = if (isOneMostCommon(oxygenGeneratorRating, index)) '1' else '0'
            oxygenGeneratorRating = oxygenGeneratorRating.filter { it.toList()[index] == commonBinary }
            index += 1
        }

        var co2ScrubberRating = input
        index = 0
        while (co2ScrubberRating.size > 1) {
            val leastCommonBinary = if (isOneMostCommon(co2ScrubberRating, index)) '0' else '1'
            co2ScrubberRating = co2ScrubberRating.filter { it.toList()[index] == leastCommonBinary }
            index += 1
        }

        val oxygenGeneratorRatingDecimal = oxygenGeneratorRating.first().toInt(2)
        val co2ScrubberRatingDecimal = co2ScrubberRating.first().toInt(2)

        return oxygenGeneratorRatingDecimal * co2ScrubberRatingDecimal
    }
}
