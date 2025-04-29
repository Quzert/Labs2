function isValidUsername(username: string): boolean {
    if (username.length < 6 || username.length > 30) {
        return false;
    }

    if (username.startsWith('.') || username.endsWith('.')) {
        return false;
    }

    if (username.includes('..')) {
        return false;
    }

    if (/[&=+<>,_'\-]/.test(username)) {
        return false;
    }

    if (!/^[a-zA-Z0-9.*]*$/.test(username)) {
        return false;
    }

    return true;
}

function emailCount(emailList: string[]): number {
    const uniqueEmails = new Set<string>();

    for (const email of emailList) {
        const parts = email.split('@');
        if (parts.length !== 2) {
            console.log(`Некорректный формат email: ${email}`);
            continue;
        }
        const [localPart, domain] = parts;

        let processedLocalPart = localPart;

        processedLocalPart = processedLocalPart.replace(/\./g, '');

        if (processedLocalPart.includes('*')) {
            processedLocalPart = processedLocalPart.split('*')[0];
        }

        if (!isValidUsername(processedLocalPart)) {
            console.log(`Некорректное имя пользователя: ${localPart} в email ${email}`);
            continue;
        }

        const processedEmail = `${processedLocalPart}@${domain}`;
        uniqueEmails.add(processedEmail);
    }

    return uniqueEmails.size;
}

const addressList1 = ["ma_r.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
const addressList2 = ["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru"];
const addressList3 = ["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru"];


console.log(`Result for addressList1: ${emailCount(addressList1)}`);
console.log(`Result for addressList2: ${emailCount(addressList2)}`);
console.log(`Result for addressList3: ${emailCount(addressList3)}`);
