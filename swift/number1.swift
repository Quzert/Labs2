let m1 = 3
let n1 = 3
let s1 = "ULDDRRUU"

func startPosFinder(m: Int, n: Int, s: String) -> (Int, Int)? {
    var x = 0
    var y = 0
    var rX = 0
    var lX = 0
    var uY = 0
    var dY = 0

    for char in s {
        switch char {
        case "D":
            y += 1
            dY = max(y, dY)
        case "U":
            y -= 1
            uY = min(y, uY)
        case "L":
            x -= 1
            lX = min(x, lX)
        case "R":
            x += 1
            rX = max(x, rX)
        default:
            break
        }
    }

    if rX - lX >= m || dY - uY >= n {
        return nil
    }
    return (1 - lX, 1 - uY)
}

if let startPos = startPosFinder(m: m1, n: n1, s: s1) {
    print(startPos)
} else {
    print("No")
}
