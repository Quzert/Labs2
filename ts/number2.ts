function isValidUsername(username: string): boolean {
    if (username.length < 6 || username.length > 30) return false;
    if (username.startsWith('.') || username.endsWith('.')) return false;
    if (username.includes('..')) return false;
    if (/[&=+<>,_'\-]/.test(username)) return false;
    if (!/^[a-zA-Z0-9.]*$/.test(username)) return false;
    return true;
}

function emailCount(emailList: string[]): number {
    const uniqueEmails = new Set<string>();

    for (const email of emailList) {
        const [localPart, domain] = email.split('@');
        if (!domain || !isValidUsername(localPart)) {
            console.log(`Некорректное имя пользователя: ${localPart}`);
            continue;
        }

        let local = localPart.replace(/\./g, '');
        if (local.includes('*')) {
            local = local.split('*')[0];
        }

        uniqueEmails.add(`${local}@${domain}`);
    }

    return uniqueEmails.size;
}

const addressList1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
const addressList2 = ["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru"];
const addressList3 = ["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru"];

console.log(emailCount(addressList1)); // 1
console.log(emailCount(addressList2)); // 1
console.log(emailCount(addressList3)); // 2