import java.util.Scanner

fun cntNonDecSeries(scanner: Scanner): Int {
    var lenSeries = 0
    var cnt = 0

    val len = scanner.nextInt()

    if (len > 0) {
        var num1 = scanner.nextInt()
        var num2: Int

        for (i in 1 until len) {
            num2 = scanner.nextInt()
            if (num2 >= num1) {
                lenSeries++
            } else if (lenSeries != 0) {
                cnt++
                lenSeries = 0
            }
            num1 = num2
        }

        if (lenSeries != 0) {
            cnt++
        }
    }
    return cnt
}

fun main() {
    val scanner = Scanner(System.`in`)
    val result = cntNonDecSeries(scanner)
    println("Количество неубывающих серий: $result")
    scanner.close()
}