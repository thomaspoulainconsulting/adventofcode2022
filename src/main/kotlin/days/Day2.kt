package days

class Day2 : Day(2, "Rock Paper Scissors") {

    enum class OPPONENT(val char: Char, val winAgainst: Char) {
        ROCK('A', 'Z'), PAPER('B', 'X'), SCISSORS('C', 'Y')
    }

    enum class ME(val char: Char, val winAgainst: Char) {
        ROCK('X', 'C'), PAPER('Y', 'A'), SCISSORS('Z', 'B')
    }


    override fun solvePart1(input: List<String>): String {
        // the rules are
        // The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors
        // The second column is what you should play in response: X for Rock, Y for Paper, and Z for Scissors

        var totalScore = 0
        input.map { line ->
            val opponent = OPPONENT.values().find { it.char == line[0] }!!
            val me = ME.values().find { it.char == line[2] }!!

            totalScore += computeScore(opponent, me)
        }

        return totalScore.toString()
    }

    private fun computeScore(opponent: OPPONENT, me: ME): Int {
        // It's a draw
        if (opponent.ordinal == me.ordinal) {
            return 3 + (me.ordinal + 1)
        }

        // we win
        return if (me.winAgainst == opponent.char) {
            6 + me.ordinal + 1
        } else {
            // we lose
            me.ordinal + 1
        }
    }

    override fun solvePart2(input: List<String>): String {
        // the second column says how the round needs to end:
        // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win

        var totalScore = 0
        input.map { line ->
            val opponent = OPPONENT.values().find { it.char == line[0] }!!
            val me = ME.values().find { it.char == line[2] }!!

            when (me.char) {
                'Y' -> {
                    // I must do a draw
                    totalScore += opponent.ordinal + 1 + 3
                }
                'X' -> {
                    // I need to lose
                    totalScore += ME.values().find { it.char == opponent.winAgainst }!!.ordinal + 1
                }
                'Z' -> {
                    // I need to win
                    totalScore += ME.values().find { it.winAgainst == opponent.char }!!.ordinal + 1 + 6
                }
            }
        }

        return totalScore.toString()
    }
}