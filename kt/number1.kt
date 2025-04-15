val m = 3
val n = 3
val s = "ULDDRRUU"

fun startPosFinder(m: Int, n: Int, s: String): Any {
    var x = 0
    var y = 0
    var rX = 0
    var lX = 0
    var uY = 0
    var dY = 0

    for (i in s) {
        when (i) {
            'D' -> {
                y += 1
                if (y > dY) dY = y
            }
            'U' -> {
                y -= 1
                if (y < uY) uY = y
            }
            'L' -> {
                x -= 1
                if (x < lX) lX = x
            }
            'R' -> {
                x += 1
                if (x > rX) rX = x
            }
        }
    }

    return if (rX - lX >= m || dY - uY >= n) {
        "No"
    } else {
        Pair(1 - lX, 1 - uY)
    }
}

fun main() {
    println(startPosFinder(m, n, s))
}