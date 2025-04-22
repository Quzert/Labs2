import re

def is_valid_username(username):
    if len(username) < 6 or len(username) > 30:
        return False
    if re.search(r"[&=+<>,_'\-]", username):
        return False
    if username.startswith('.') or username.endswith('.'):
        return False
    if '..' in username:
        return False
    if not re.match(r"^[a-zA-Z0-9.]*$", username):
        return False
    return True

def email_count(email_list):
    unique_emails = set()

    for email in email_list:
        local, domain = email.split('@')
        if not is_valid_username(local):
            print(f"Некорректное имя пользователя: {local}")
            continue

        local = local.replace('.', '')
        if '*' in local:
            local = local.split('*')[0]

        unique_emails.add(local + '@' + domain)

    return len(unique_emails)

address_list = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]
print(email_count(address_list))