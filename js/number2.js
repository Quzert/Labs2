function isValidUsername(username) {
    if (username.length < 6 || username.length > 30) return false;
    if (/[&=+<>,_'-]/.test(username)) return false;
    if (username.startsWith('.') || username.endsWith('.')) return false;
    if (username.includes('..')) return false;
    if (!/^[a-zA-Z0-9.*]*$/.test(username)) return false;
    return true;
}

function emailCount(emailList) {
    // Используем Set для хранения уникальных нормализованных адресов
    const uniqueEmails = new Set();

    for (const email of emailList) {
        const atPos = email.indexOf('@');
        if (atPos <= 0 || atPos === email.length - 1) {
            continue;
        }

        let local = email.substring(0, atPos);
        const domain = email.substring(atPos + 1);

        // Сначала валидируем оригинальное имя пользователя
        if (!isValidUsername(local)) {
            continue;
        }

        // Нормализация: убираем все после '*' и удаляем все '.'
        const starPos = local.indexOf('*');
        if (starPos !== -1) {
            local = local.substring(0, starPos);
        }
        const cleanedLocal = local.replace(/\./g, '');

        uniqueEmails.add(cleanedLocal + "@" + domain);
    }
    return uniqueEmails.size;
}

// Example Usage:
const addressList1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
const addressList2 = ["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"];
const addressList3 = ["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"];

console.log("List 1 Count:", emailCount(addressList1));
console.log("List 2 Count:", emailCount(addressList2));
console.log("List 3 Count:", emailCount(addressList3));