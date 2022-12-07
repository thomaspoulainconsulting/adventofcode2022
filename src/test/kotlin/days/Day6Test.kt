package days

import junit.framework.TestCase
import org.junit.Test

class Day6Test : AdventOfCodeTest {

    private val day = Day6()
    private val input =
        """
           mjqjpqmgbljsphdztnvjfqwrcgsmlb
           bvwbjplbgvbhsrlpgdmjqwftvncz
           nppdvjthqldpwncqszvftbrmjlhg
           nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg
           zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw
        """.trimIndent().split('\n')

    @Test
    override fun solvePart1Test() {
        TestCase.assertEquals("7", day.solvePart1(listOf(input[0])))
        TestCase.assertEquals("5", day.solvePart1(listOf(input[1])))
        TestCase.assertEquals("6", day.solvePart1(listOf(input[2])))
        TestCase.assertEquals("10", day.solvePart1(listOf(input[3])))
        TestCase.assertEquals("11", day.solvePart1(listOf(input[4])))
    }

    @Test
    override fun solvePart2Test() {
        //TestCase.assertEquals("MCD", day.solvePart2(input))
    }
}