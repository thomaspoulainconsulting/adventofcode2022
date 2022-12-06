package days

import org.junit.Test

class MainTest {

    private val tests = listOf(
        Day1Test(),
        Day2Test(),
        Day3Test(),
    )

    @Test
    fun main() {
        tests.forEach {
            it.solvePart1Test()
            it.solvePart2Test()
        }
    }
}