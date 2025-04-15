const addresList1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
const addresList2 = ["mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];
const addresList3 = ["mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];

function emailCount(emailList: string[]): number {
    const uniqueEmails = new Set<string>();

    for (const email of emailList) {
        let [local, domain] = email.split('@');
        local = local.replace(/\./g, '');
        if (local.includes('+')) {
            local = local.split('+')[0];
        }
        uniqueEmails.add(`${local}@${domain}`);
    }

    return uniqueEmails.size;
}

console.log(emailCount(addresList1));  // 1
console.log(emailCount(addresList2));  // 1
console.log(emailCount(addresList3));  // 2