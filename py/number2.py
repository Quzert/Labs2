import re

def is_valid_username_py(username):
    if not 6 <= len(username) <= 30: return False
    if re.search(r"[&=+<>,_'-]", username): return False
    if username.startswith('.') or username.endswith('.'): return False
    if '..' in username: return False
    if not re.fullmatch(r"^[a-zA-Z0-9.*]*$", username): return False
    return True

def email_count_py(email_list):
    # Используем set для хранения уникальных нормализованных адресов
    unique_emails = set()

    for email in email_list:
        at_pos = email.find('@')
        if at_pos <= 0 or at_pos == len(email) - 1:
            continue

        local_part = email[:at_pos]
        domain_part = email[at_pos+1:]

        # Сначала валидируем оригинальное имя пользователя
        if not is_valid_username_py(local_part):
            continue

        # Нормализация: убираем все после '*' и удаляем все '.'
        star_pos = local_part.find('*')
        if star_pos != -1:
            local_part = local_part[:star_pos]
        cleaned_local = local_part.replace('.', '')

        unique_emails.add(cleaned_local + "@" + domain_part)

    return len(unique_emails)

# Example Usage:
address_list1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]
address_list2 = ["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"]
address_list3 = ["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"]

print(f"List 1 Count: {email_count_py(address_list1)}")
print(f"List 2 Count: {email_count_py(address_list2)}")
print(f"List 3 Count: {email_count_py(address_list3)}")