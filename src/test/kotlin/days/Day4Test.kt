package days

import junit.framework.TestCase
import org.junit.Test

class Day4Test : AdventOfCodeTest {

    private val day = Day4()
    private val input =
        """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        TestCase.assertEquals("2", day.solvePart1(input))
    }

    @Test
    override fun solvePart2Test() {
        TestCase.assertEquals("4", day.solvePart2(input))
    }
}