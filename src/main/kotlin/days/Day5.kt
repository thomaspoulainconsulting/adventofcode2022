package days

import java.util.regex.Pattern


class Day5 : Day(5, "Supply Stacks") {

    class Instruction(val numberOfCrateToMove: Int, val columnFrom: Int, val columnTo: Int)

    override fun solvePart1(input: List<String>): String {
        return moveCrates(input, false)
    }

    override fun solvePart2(input: List<String>): String {
        return moveCrates(input, true)
    }

    private fun moveCrates(input: List<String>, keepOrder: Boolean): String {
        val crates = MutableList<MutableList<Char>>(size = 9) { mutableListOf() }
        val instructions = mutableListOf<Instruction>()

        input.forEach { line ->
            // read up all crates
            if (line.contains('[')) {
                line.forEachIndexed { index, crate ->
                    if (crate.isLetter()) {
                        crates[index / 4].add(crate)
                    }
                }
            }

            // read all moves
            if (line.contains("move")) {
                Pattern.compile("move (\\d+) from (\\d) to (\\d)").toRegex()
                    .find(line)?.groupValues?.let {
                        instructions.add(
                            Instruction(
                                numberOfCrateToMove = it[1].toInt(),
                                columnFrom = it[2].toInt() - 1,
                                columnTo = it[3].toInt() - 1
                            )
                        )
                    }
            }
        }

        // Reverse the crates
        crates.map { it.reverse() }

        // execute the moves
        instructions.forEach { instruction ->

            // We extract the items to move
            val subListFrom = crates[instruction.columnFrom].size - instruction.numberOfCrateToMove
            val elementToMove = crates[instruction.columnFrom].subList(
                subListFrom,
                crates[instruction.columnFrom].size
            )

            // We remove the items
            crates[instruction.columnFrom] =
                crates[instruction.columnFrom].dropLast(instruction.numberOfCrateToMove)
                    .toMutableList()

            // We add the items to the right column
            elementToMove
                .apply {
                    if (!keepOrder) reverse()
                }.forEach {
                    crates[instruction.columnTo].add(it)
                }
        }

        // We forge the result with the last char element of each crate
        var result = ""
        crates.forEach {
            if (it.isNotEmpty()) {
                result += it.last()
            }
        }

        return result
    }
}