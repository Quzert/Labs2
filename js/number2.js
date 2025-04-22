function isValidUsername(username) {
    if (username.length < 6 || username.length > 30) return false;
    if (/[&=+<>,_'\-]/.test(username)) return false;
    if (username.startsWith('.') || username.endsWith('.')) return false;
    if (username.includes('..')) return false;
    if (!/^[a-zA-Z0-9.]*$/.test(username)) return false;
    return true;
}

function emailCount(emailList) {
    const uniqueEmails = new Set();

    emailList.forEach(email => {
        let [local, domain] = email.split('@');

        if (!isValidUsername(local)) {
            console.log(`Некорректное имя пользователя: ${local}`);
            return;
        }

        local = local.replace(/\./g, '');
        if (local.includes('*')) {
            local = local.split('*')[0];
        }

        uniqueEmails.add(`${local}@${domain}`);
    });

    return uniqueEmails.size;
}

const addressList = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
console.log(emailCount(addressList));