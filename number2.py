addres_list1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]  #1
addres_list2 = ["mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"]  #1
addres_list3 = ["mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"] #2

def email_count(email_list):
    unique_emails = set()

    for email in email_list:
        local, domain = email.split('@')
        local = local.replace('.', '')
        if '+' in local:
            local = local.split('+')[0]  # Удаляем часть после '+'
        unique_emails.add(local + '@' + domain)

    return len(unique_emails)

print(email_count(addres_list1))  # 1
print(email_count(addres_list2))  # 1
print(email_count(addres_list3))  # 2


