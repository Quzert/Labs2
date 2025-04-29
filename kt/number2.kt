val FORBIDDEN_CHARS_REGEX_KT = Regex("[&=+<>,_'-]")
val ALLOWED_CHARS_REGEX_KT = Regex("^[a-zA-Z0-9.*]*$")

// Проверка имени пользователя на соответствие правилам
fun isValidUsernameKt(username: String): Boolean {
    if (username.length !in 6..30) return false
    if (username.contains(FORBIDDEN_CHARS_REGEX_KT)) return false
    if (username.startsWith('.') || username.endsWith('.')) return false
    if (username.contains("..")) return false
    if (!username.matches(ALLOWED_CHARS_REGEX_KT)) return false
    return true
}

fun emailCountKt(emailList: List<String>): Int {
    // Используем Set для хранения уникальных нормализованных адресов
    val uniqueEmails = HashSet<String>()

    for (email in emailList) {
        val atPos = email.indexOf('@')
        if (atPos <= 0 || atPos == email.length - 1) {
            continue
        }

        var local = email.substringBefore('@')
        val domain = email.substringAfter('@')

        // Сначала валидируем оригинальное имя пользователя
         if (!isValidUsernameKt(local)) {
            continue
        }

        // Нормализация: убираем все после '*' и удаляем все '.'
        val starPos = local.indexOf('*')
        if (starPos != -1) {
            local = local.substring(0, starPos)
        }
        val cleanedLocal = local.replace(".", "")

        uniqueEmails.add("$cleanedLocal@$domain")
    }
    return uniqueEmails.size
}

fun main() {
    val addressList1 = listOf("mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru")
    val addressList2 = listOf("mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru")
    val addressList3 = listOf("mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru")

    println("List 1 Count: ${emailCountKt(addressList1)}")
    println("List 2 Count: ${emailCountKt(addressList2)}")
    println("List 3 Count: ${emailCountKt(addressList3)}")
}