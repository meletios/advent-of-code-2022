fun main() {
    var leftA = 0
    var leftB = 0
    var rightA = 0
    var rightB = 0

    fun rearrangeParts(parts: List<String>) {
        if (parts[0].toInt() <= parts[2].toInt()) {
            leftA = parts[0].toInt()
            leftB = parts[1].toInt()
            rightA = parts[2].toInt()
            rightB = parts[3].toInt()
        } else {
            leftA = parts[2].toInt()
            leftB = parts[3].toInt()
            rightA = parts[0].toInt()
            rightB = parts[1].toInt()
        }
    }

    fun getResults(input: List<String>, looseOverlapping: Boolean): Int {
        var overlappingPairs = 0
        var looseOverlappingPairs = 0

        input.forEach { line ->
            val parts = line.split(",", "-")

            rearrangeParts(parts)

            if ((leftA <= rightA || leftA <= rightB) && leftB >= rightB) {
                overlappingPairs++

            } else if (rightA <= leftA && rightB >= leftB) {
                overlappingPairs++
            } else if (leftB >= rightA || rightB <= leftA) {
                looseOverlappingPairs++
            }
        }
        return if (looseOverlapping) looseOverlappingPairs + overlappingPairs else overlappingPairs
    }

    val inputPart2 = readInput("Day04")
    println("Part 2 Result - ${getResults(inputPart2, true)}")
}
