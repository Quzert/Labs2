const emailCount = (emailList) => {
    const uniqueEmails = new Set();

    emailList.forEach(email => {
        let [local, domain] = email.split('@');
        local = local.replace(/\./g, '');
        if (local.includes('+')) {
            local = local.split('+')[0]; // Удаляем часть после '+'
        }
        uniqueEmails.add(`${local}@${domain}`);
    });

    return uniqueEmails.size;
};

const addressList1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
const addressList2 = ["mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];
const addressList3 = ["mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];

console.log(emailCount(addressList1)); // 1
console.log(emailCount(addressList2)); // 1
console.log(emailCount(addressList3)); // 2