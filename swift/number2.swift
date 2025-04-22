import Foundation

func isValidUsername(_ username: String) -> Bool {
    if username.count < 6 || username.count > 30 {
        return false
    }

    if username.hasPrefix(".") || username.hasSuffix(".") {
        return false
    }

    if username.contains("..") {
        return false
    }

    if username.range(of: "[&=+<>,_'-]", options: .regularExpression) != nil {
        return false
    }

    if username.range(of: "^[a-zA-Z0-9.]*$", options: .regularExpression) == nil {
        return false
    }

    return true
}

func emailCount(emailList: [String]) -> Int {
    var uniqueEmails = Set<String>()

    for email in emailList {
        let parts = email.split(separator: "@")
        var local = String(parts[0])
        let domain = String(parts[1])

        if !isValidUsername(local) {
            print("Некорректное имя пользователя: \(local)")
            continue
        }

        local = local.replacingOccurrences(of: ".", with: "")
        if let starIndex = local.firstIndex(of: "*") {
            local = String(local[..<starIndex])
        }

        uniqueEmails.insert("\(local)@\(domain)")
    }

    return uniqueEmails.count
}

let addressList1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]
print(emailCount(emailList: addressList1))