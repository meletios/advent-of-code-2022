import java.util.InputMismatchException

fun main() {
    fun part1(input: List<String>): Int {
        var maxCalories : Int = 0
        var tempSum : Int = 0

        input.forEach { line ->
            println("line $line, maxcalories $maxCalories, tempSum $tempSum")
            when(val test = line.toIntOrNull()) {
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
        var tempSum : Int = 0

        input.forEachIndexed { index, line ->
            println("line $line, firstMaxCalories $firstMaxCalories, secondMaxCalories $secondMaxCalories, thirdMaxCalories $thirdMaxCalories, tempSum $tempSum")
            when(val test = line.toIntOrNull()) {
                null -> {
                    if (tempSum > firstMaxCalories) {
                        thirdMaxCalories = secondMaxCalories
                        secondMaxCalories = firstMaxCalories
                        firstMaxCalories = tempSum
                    } else if (tempSum > secondMaxCalories){
                        thirdMaxCalories = secondMaxCalories
                        secondMaxCalories = tempSum
                    }else if (tempSum > thirdMaxCalories){
                        thirdMaxCalories = tempSum
                    }
                    tempSum = 0
                }
                else -> {
                    tempSum += test
                    if (index == input.size-1){
                        if (tempSum > firstMaxCalories) {
                            thirdMaxCalories = secondMaxCalories
                            secondMaxCalories = firstMaxCalories
                            firstMaxCalories = tempSum
                        } else if (tempSum > secondMaxCalories){
                            thirdMaxCalories = secondMaxCalories
                            secondMaxCalories = tempSum
                        }else if (tempSum > thirdMaxCalories){
                            thirdMaxCalories = tempSum
                        }
                    }

                }
            }
        }
        println("SUM ${firstMaxCalories + secondMaxCalories + thirdMaxCalories}")
        return firstMaxCalories + secondMaxCalories + thirdMaxCalories
    }

    fun test(tempSum : Int, firstMaxCalories: Int, secondMaxCalories: Int, thirdMaxCalories: Int) {

    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //println(part1(testInput))
    //check(part1(testInput) == 24000)

    val testInput = readInput("Day01_test")
    //println(part2(testInput))
    //check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part2(input))
}
