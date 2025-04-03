fun countNonDecreasingSeries(sequence: List<Int>): Int {
    var cnt = 0
    val n = sequence.size
    var i = 0
    while (i < n - 1) {
        if (sequence[i] <= sequence[i + 1]) {
            cnt += 1
            while (i < n - 1 && sequence[i] <= sequence[i + 1]) {
                i += 1
            }
        } else {
            i += 1
        }
    }
    return cnt
}

fun strToList(s: String): List<Int> {
    return s.map { it.toString().toInt() }
}

fun main() {
    val sequence1 = listOf(5, 1, 2, 3, 2, 5)
    println("Количество неубывающих серий №1: ${countNonDecreasingSeries(sequence1)}")

    val sequence2 = strToList("484756344")
    println("Количество неубывающих серий №2: ${countNonDecreasingSeries(sequence2)}")

    val sequence3 = strToList("12345678998765432123456789987654321")
    println("Количество неубывающих серий №3: ${countNonDecreasingSeries(sequence3)}")
}