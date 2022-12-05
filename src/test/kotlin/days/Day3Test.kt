package days

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Day3Test {

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
    fun solvePart1Test() {
        assertEquals("157", day.solvePart1(input))
    }

    @Test
    fun solvePart2Test() {
        //assertEquals("12", day.solvePart2(input))
    }
}