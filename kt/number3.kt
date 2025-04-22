fun countNonDecreasingSeries(sequence: String): Int {
    var cnt = 0
    val n = sequence.length
    var i = 0
    while (i < n - 1) {
        if (sequence[i] <= sequence[i + 1]) {
            cnt++
            while (i < n - 1 && sequence[i] <= sequence[i + 1]) {
                i++
            }
        } else {
            i++
        }
    }
    return cnt
}

fun main() {
    val sequence1 = "512325"
    println("Количество неубывающих серий №1: ${countNonDecreasingSeries(sequence1)}")

    val sequence2 = "484756344"
    println("Количество неубывающих серий №2: ${countNonDecreasingSeries(sequence2)}")

    val sequence3 = "12345678998765432123456789987654321"
    println("Количество неубывающих серий №3: ${countNonDecreasingSeries(sequence3)}")
}