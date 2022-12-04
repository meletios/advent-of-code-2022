import java.util.InputMismatchException

fun main() {
    fun part1(input: List<String>): Int {
        var maxCalories: Int = 0
        var tempSum: Int = 0

        input.forEach { line ->
            when (val test = line.toIntOrNull()) {
                null -> {
                    if (tempSum > maxCalories) {
                        maxCalories = tempSum
                    }
                    tempSum = 0
                }

                else -> tempSum += test
            }
        }
        return maxCalories
    }

    fun part2(input: List<String>): Int {
        var firstMaxCalories = 0
        var secondMaxCalories = 0
        var thirdMaxCalories = 0
        var tempSum: Int = 0

        fun test() {
            if (tempSum > firstMaxCalories) {
                thirdMaxCalories = secondMaxCalories
                secondMaxCalories = firstMaxCalories
                firstMaxCalories = tempSum
            } else if (tempSum > secondMaxCalories) {
                thirdMaxCalories = secondMaxCalories
                secondMaxCalories = tempSum
            } else if (tempSum > thirdMaxCalories) {
                thirdMaxCalories = tempSum
            }
        }
        input.forEachIndexed { index, line ->
           when (val test = line.toIntOrNull()) {
                null -> {
                    test()
                    tempSum = 0
                }

                else -> {
                    tempSum += test
                    if (index == input.size - 1) {
                        test()
                    }

                }
            }
        }
        return firstMaxCalories + secondMaxCalories + thirdMaxCalories
    }


    // test if implementation meets criteria from the description, like:
    val testInputPart1 = readInput("Day01_test")
    check(part1(testInputPart1) == 24000)

    val testInputPart2 = readInput("Day01_test")
    check(part2(testInputPart2) == 45000)

    val input = readInput("Day01")
    println(part2(input))
}
