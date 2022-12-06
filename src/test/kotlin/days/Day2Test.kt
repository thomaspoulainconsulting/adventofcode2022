package days

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Day2Test: AdventOfCodeTest {

    private val day = Day2()
    private val input =
        """
            A Y
            B X
            C Z
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("15", day.solvePart1(input))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("12", day.solvePart2(input))
    }
}