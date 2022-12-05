package days

class Day3 : Day(3, "Rucksack Reorganization") {

    override fun solvePart1(input: List<String>): String {
        return input.sumOf { line ->
            val firstPart = line.slice(0..(line.length - 1) / 2).toList()
            val secondPart = line.slice(line.length / 2 until line.length).toList()

            // find the same letter in both part
            val letterInBothPart = firstPart.intersect(secondPart).first()

            // we convert it to a priority that have a value
            convertLetterToPriority(letterInBothPart)

        }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        return input.chunked(3).sumOf { group ->
            // the elf group
            val firstLine = group[0].toList()
            val secondLine = group[1].toList()
            val thirdLine = group[2].toList()

            // we find the common letter in all three lines
            val letterInEveryGroup: Char = firstLine.intersect(secondLine).intersect(thirdLine).first()

            // we convert it to a priority that have a value
            convertLetterToPriority(letterInEveryGroup)

        }.toString()
    }

    private fun convertLetterToPriority(letter: Char): Int {
        return if (letter.isLowerCase()) ('a'..'z').indexOf(letter) + 1
        else ('A'..'Z').indexOf(letter) + 26 + 1
    }
}