package days

import junit.framework.TestCase
import org.junit.Test

class Day5Test: AdventOfCodeTest {

    private val day = Day5()
    private val input =
        """
                [D]    
            [N] [C]    
            [Z] [M] [P]
             1   2   3 
            
            move 1 from 2 to 1
            move 3 from 1 to 3
            move 2 from 2 to 1
            move 1 from 1 to 2
        """.trimIndent().split('\n')

    @Test
    override fun solvePart1Test() {
        TestCase.assertEquals("CMZ", day.solvePart1(input))
    }

    @Test
    override fun solvePart2Test() {
        //TestCase.assertEquals("4", day.solvePart2(input))
    }
}