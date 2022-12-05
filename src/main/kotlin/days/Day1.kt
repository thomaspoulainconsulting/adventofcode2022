package days

class Day1 : Day(1, "Calorie Counting") {

    override fun solvePart1(input: List<String>): String {
        return getElfs(input)
            .max()
            .toString()
    }

    override fun solvePart2(input: List<String>): String {
        return getElfs(input)
            .sortedDescending().subList(0, 3)
            .sum()
            .toString()
    }

    private fun getElfs(input: List<String>): List<Int> {
        val elfs = mutableListOf<Int>()

        var currentCaloriesElf = 0
        input.forEach {
            if (it.isNotEmpty()) {
                currentCaloriesElf += it.toInt()
            } else {
                elfs.add(currentCaloriesElf)
                currentCaloriesElf = 0
            }
        }

        return elfs
    }

}