package days

import java.util.regex.Pattern


class Day5 : Day(5, "Supply Stacks") {

    class Instruction(val numberOfCrateToMove: Int, val columnFrom: Int, val columnTo: Int)

    override fun solvePart1(input: List<String>): String {

        val crates: MutableList<MutableList<Char>> = MutableList(size = 9) { mutableListOf() }
        val instructions = mutableListOf<Instruction>()

        input.forEach { line ->
            if (line.contains('[')) {
                line.forEachIndexed { index, crate ->
                    if (crate.isLetter()) {
                        crates[index / 4].add(crate)
                    }
                }
            }

            if (line.contains("move")) {
                Pattern.compile("move (\\d+) from (\\d) to (\\d)").toRegex()
                    .find(line)?.groupValues?.let {
                    instructions.add(
                        Instruction(
                            it[1].toInt(),
                            it[2].toInt() - 1,
                            it[3].toInt() - 1
                        )
                    )
                }
            }
        }

        crates.map {
            it.reverse()
        }

        // execute the moves
        instructions.forEach { instruction ->
            val elementToMove =
                crates[instruction.columnFrom].subList(crates[instruction.columnFrom].size-instruction.numberOfCrateToMove, crates[instruction.columnFrom].size)
            crates[instruction.columnFrom] = crates[instruction.columnFrom].dropLast(instruction.numberOfCrateToMove).toMutableList()

            elementToMove.apply { reverse() }.forEach {
                crates[instruction.columnTo].add(it)
            }
        }

        // results
        var result = ""
        crates.forEach {
            if (it.isNotEmpty()) {
                result += it.last()
            }
        }

        return result
    }

    override fun solvePart2(input: List<String>): String {
        return ""
    }
}