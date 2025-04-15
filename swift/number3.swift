func countNonDecreasingSeries(sequence: [Int]) -> Int {
    var cnt = 0
    let n = sequence.count
    var i = 0
    while i < n - 1 {
        if sequence[i] <= sequence[i + 1] {
            cnt += 1
            while i < n - 1 && sequence[i] <= sequence[i + 1] {
                i += 1
            }
        } else {
            i += 1
        }
    }
    return cnt
}

func strToList(s: String) -> [Int] {
    return s.compactMap { Int(String($0)) }
}

let sequence1Swift = [5, 1, 2, 3, 2, 5]
print("Количество неубывающих серий №1: \(countNonDecreasingSeries(sequence: sequence1Swift))")

let sequence2Swift = strToList(s: "484756344")
print("Количество неубывающих серий №2: \(countNonDecreasingSeries(sequence: sequence2Swift))")

let sequence3Swift = strToList(s: "12345678998765432123456789987654321")
print("Количество неубывающих серий №3: \(countNonDecreasingSeries(sequence: sequence3Swift))")