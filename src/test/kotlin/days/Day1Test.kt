package days

import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {

    private val day = Day1()
    private val input =
        """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000
            
        """.trimIndent().split('\n')


    @Test
    fun solvePart1Test() {
        assertEquals("24000", day.solvePart1(input))
    }

    @Test
    fun solvePart2Test() {
        assertEquals("45000", day.solvePart2(input))
    }
}