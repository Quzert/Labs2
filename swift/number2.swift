// Swift
import Foundation

let forbiddenCharsSwift = CharacterSet(charactersIn: "&=+<>,_'-")
let allowedCharsBaseSwift = CharacterSet.alphanumerics.union(CharacterSet(charactersIn: ".*"))

// Проверка имени пользователя на соответствие правилам
func isValidUsernameSwift(username: String) -> Bool {
    guard username.count >= 6 && username.count <= 30 else { return false }
    guard username.rangeOfCharacter(from: forbiddenCharsSwift) == nil else { return false }
    guard !username.hasPrefix(".") && !username.hasSuffix(".") else { return false }
    guard !username.contains("..") else { return false }
    guard username.rangeOfCharacter(from: allowedCharsBaseSwift.inverted) == nil else { return false }
    return true
}

func emailCountSwift(emailList: [String]) -> Int {
    // Используем Set для хранения уникальных нормализованных адресов
    var uniqueEmails = Set<String>()

    for email in emailList {
        guard let atIndex = email.firstIndex(of: "@"),
              atIndex > email.startIndex,
              atIndex < email.index(before: email.endIndex)
        else {
            continue
        }

        var local = String(email[..<atIndex])
        let domain = String(email[email.index(after: atIndex)...])

        // Сначала валидируем оригинальное имя пользователя
        guard isValidUsernameSwift(username: local) else {
            continue
        }

        // Нормализация: убираем все после '*' и удаляем все '.'
        if let starIndex = local.firstIndex(of: "*") {
            local = String(local[..<starIndex])
        }
        let cleanedLocal = local.replacingOccurrences(of: ".", with: "")

        uniqueEmails.insert(cleanedLocal + "@" + domain)
    }
    return uniqueEmails.count
}

// Example Usage:
let addressList1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]
let addressList2 = ["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"]
let addressList3 = ["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"]

print("List 1 Count: \(emailCountSwift(emailList: addressList1))")
print("List 2 Count: \(emailCountSwift(emailList: addressList2))")
print("List 3 Count: \(emailCountSwift(emailList: addressList3))")