package days

import kotlin.math.max
import kotlin.math.min

class Day4 : Day(4, "Camp Cleanup") {

    private fun IntRange.inside(another: IntRange): Boolean =
        this.min()!! >= another.min()!! && this.max()!! <= another.max()!!

    private fun IntRange.overlap(another: IntRange): Boolean =
        max(this.min()!!,another.min()!!) <= min(this.max()!!,another.max()!!)

    override fun solvePart1(input: List<String>): String {
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
        var total = 0

        input.forEach { line ->
            val firstPart = line.split(',').first()
            val secondPart = line.split(',').last()

            val firstRange = firstPart.split('-').first().toInt()..firstPart.split('-').last().toInt()
            val secondRange = secondPart.split('-').first().toInt()..secondPart.split('-').last().toInt()

            if (firstRange.overlap(secondRange) || secondRange.overlap(firstRange)) {
                total++
            }
        }

        return total.toString()
    }
}