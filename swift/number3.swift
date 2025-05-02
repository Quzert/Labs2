import Foundation

func cntNonDecSeries() -> Int {
    var lenSeries = 0
    var cnt = 0

    let len = Int(readLine()!)!

    if len > 0 {
        var num1 = Int(readLine()!)!
        var num2 = 0

        for _ in 1..<len {
            num2 = Int(readLine()!)!

            if num2 >= num1 {
                lenSeries += 1
            } else if lenSeries != 0 {
                cnt += 1
                lenSeries = 0
            }
            num1 = num2
        }

        if lenSeries != 0 {
            cnt += 1
        }
    }
    return cnt
}

let result = cntNonDecSeries()
print("Количество неубывающих серий: \(result)")