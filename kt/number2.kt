val addresList1 = listOf("mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru")  // 1
val addresList2 = listOf("mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru")  // 1
val addresList3 = listOf("mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru")  // 2

fun emailCount(emailList: List<String>): Int {
    val uniqueEmails = mutableSetOf<String>()

    for (email in emailList) {
        val (local, domain) = email.split('@')
        var processedLocal = local.replace(".", "")
        if ('+' in processedLocal) {
            processedLocal = processedLocal.split('+')[0]  // Удаляем часть после '+'
        }
        uniqueEmails.add("$processedLocal@$domain")
    }

    return uniqueEmails.size
}

fun main() {
    println(emailCount(addresList1))  // 1
    println(emailCount(addresList2))  // 1
    println(emailCount(addresList3))  // 2
}