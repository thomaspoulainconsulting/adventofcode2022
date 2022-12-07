package days

class Day6 : Day(6, "Tuning Trouble") {

    override fun solvePart1(input: List<String>): String {
        return findMarker(input[0], 4)
    }

    override fun solvePart2(input: List<String>): String {
        return findMarker(input[0], 14)
    }

    private fun findMarker(line: String, marker: Int): String {
        val buffer = mutableListOf<Char>()

        line.forEachIndexed { index, char ->
            // We first fill the buffer
            if (index < marker) {
                buffer.add(char)
            } else {
                // We check if all element of buffer are the same
                if (buffer.distinct().size == marker) {
                    return index.toString()
                } else {
                    // we shift the element of the buffer
                    buffer.apply {
                        add(char)
                        removeAt(0)
                    }
                }
            }
        }

        return ""
    }
}