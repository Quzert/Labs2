import Foundation

let addresList1Swift = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]
let addresList2Swift = ["mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"]
let addresList3Swift = ["mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"]

func emailCount(emailList: [String]) -> Int {
    var uniqueEmails = Set<String>()
    for email in emailList {
        if let atIndex = email.firstIndex(of: "@") {
            let localPart = String(email[..<atIndex]).components(separatedBy: ".").joined()
            let domainPart = String(email[atIndex...])
            if let plusIndex = localPart.firstIndex(of: "+") {
                uniqueEmails.insert(String(localPart[..<plusIndex]) + domainPart)
            } else {
                uniqueEmails.insert(localPart + domainPart)
            }
        }
    }
    return uniqueEmails.count
}

print(emailCount(emailList: addresList1Swift))
print(emailCount(emailList: addresList2Swift))
print(emailCount(emailList: addresList3Swift))