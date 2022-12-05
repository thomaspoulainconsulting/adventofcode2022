package days

class Day2 : Day(2, "Rock Paper Scissors") {

    enum class OPPONENT(val char: Char, val winAgainst: Char) {
        ROCK('A', 'Z'), PAPER('B', 'X'), SCISSORS('C', 'Y');
        fun level(): Int = ordinal + 1
    }

    enum class ME(val char: Char, val winAgainst: Char) {
        ROCK('X', 'C'), PAPER('Y', 'A'), SCISSORS('Z', 'B');
        fun level(): Int = ordinal + 1
    }


    override fun solvePart1(input: List<String>): String {
        // the rules are
        // The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors
        // The second column is what you should play in response: X for Rock, Y for Paper, and Z for Scissors

        return input.sumOf { line ->
            val opponent = OPPONENT.values().find { it.char == line[0] }!!
            val me = ME.values().find { it.char == line[2] }!!

            if (me.winAgainst == opponent.char) me.level() + 6 // we win
            else if (opponent.ordinal == me.ordinal) me.level() + 3 // It's a draw
            else me.level() // we lose
        }.toString()

    }


    override fun solvePart2(input: List<String>): String {
        // In fact, the second column says how the round needs to end:
        // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win

        return input.sumOf { line ->
            val opponent = OPPONENT.values().find { it.char == line[0] }!!
            val me = ME.values().find { it.char == line[2] }!!

            when (me.char) {
                'Y' -> opponent.level() + 3 // I must do a draw
                'X' -> Day2.ME.values()
                    .find { it.char == opponent.winAgainst }!!.level() // I need to lose
                'Z' -> Day2.ME.values()
                    .find { it.winAgainst == opponent.char }!!.level() + 6 // I need to win
                else -> 0
            }
        }.toString()
    }
}