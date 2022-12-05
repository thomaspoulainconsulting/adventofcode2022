package days

class Day3 : Day(3, "Rucksack Reorganization") {

    override fun solvePart1(input: List<String>): String {

        return input.sumOf { line ->
            val firstPart = line.slice(0..(line.length - 1) / 2).toList()
            val secondPart = line.slice(line.length / 2 until line.length).toList()

            // find the same letter in both part
            val letterInBothPart = firstPart.intersect(secondPart).first()

            // we convert it to a priority that have a value
            if (letterInBothPart.isLowerCase()) ('a'..'z').indexOf(letterInBothPart) + 1
            else ('A'..'Z').indexOf(letterInBothPart) + 26 + 1

        }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        return ""
    }
}