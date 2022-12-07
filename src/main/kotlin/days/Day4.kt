package days

class Day4 : Day(4, "Camp Cleanup") {

    fun IntRange.inside(another: IntRange): Boolean {
        return this.min()!! >= another.min()!! && this.max()!! <= another.max()!!
    }

    override fun solvePart1(input: List<String>): String {
        // we need to find the number of pair that are inside another
        var total = 0

        input.forEach { line ->
            val firstPart = line.split(',').first()
            val secondPart = line.split(',').last()

            val firstRange = firstPart.split('-').first().toInt()..firstPart.split('-').last().toInt()
            val secondRange = secondPart.split('-').first().toInt()..secondPart.split('-').last().toInt()

            if (firstRange.inside(secondRange) || secondRange.inside(firstRange)) {
                total++
            }
        }

        return total.toString()
    }



    override fun solvePart2(input: List<String>): String {
        return ""
    }
}