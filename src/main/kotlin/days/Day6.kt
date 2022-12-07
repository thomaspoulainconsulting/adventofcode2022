package days

class Day6 : Day(6, "Tuning Trouble") {

    override fun solvePart1(input: List<String>): String {
        val buffer = mutableListOf<Char>()

        input[0].forEachIndexed { index, char ->

            // We fill the buffer
            if (index < 4) {
                buffer.add(char)
            } else {
                // We check if all element of buffer are the same
                if (buffer.distinct().size == 4) {
                    return index.toString()
                } else {
                    buffer.add(char)
                    buffer.removeAt(0)
                }
            }
        }

        return ""
    }

    override fun solvePart2(input: List<String>): String {
        return ""
    }
}