package days

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Day3Test: AdventOfCodeTest {

    private val day = Day3()
    private val input =
        """
            vJrwpWtwJgWrhcsFMMfFFhFp
            jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            PmmdzqPrVvPwwTWBwg
            wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            ttgJtRGJQctTZtZT
            CrZsJsPPZsGzwwsLwLmpwMDw
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("157", day.solvePart1(input))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("70", day.solvePart2(input))
    }
}