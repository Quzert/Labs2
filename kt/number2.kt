fun isValidUsername(username: String): Boolean {
    if (username.length !in 6..30) return false
    if (username.startsWith(".") || username.endsWith(".")) return false
    if (".." in username) return false
    if (username.any { it in "&=+<>,_'-" }) return false
    if (!username.all { it.isLetterOrDigit() || it == '.' }) return false
    return true
}

fun emailCount(emailList: List<String>): Int {
    val uniqueEmails = mutableSetOf<String>()

    for (email in emailList) {
        val (local, domain) = email.split('@')
        if (!isValidUsername(local)) {
            println("Некорректное имя пользователя: $local")
            continue
        }

        val cleanedLocal = local.replace(".", "").substringBefore("*")
        uniqueEmails.add("$cleanedLocal@$domain")
    }

    return uniqueEmails.size
}

fun main() {
    val addressList1 = listOf("mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru")
    println(emailCount(addressList1))
}