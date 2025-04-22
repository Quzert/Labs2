use std::collections::HashSet;

fn is_valid_username(username: &str) -> bool {
    if username.len() < 6 || username.len() > 30 {
        return false;
    }

    if username.starts_with('.') || username.ends_with('.') {
        return false;
    }

    if username.contains("..") {
        return false;
    }

    if username.chars().any(|c| "&=+<>,_'-".contains(c)) {
        return false;
    }

    if !username.chars().all(|c| c.is_alphanumeric() || c == '.') {
        return false;
    }

    true
}

fn email_count(email_list: Vec<&str>) -> usize {
    let mut unique_emails = HashSet::new();

    for email in email_list {
        let parts: Vec<&str> = email.split('@').collect();
        let mut local = parts[0];
        let domain = parts[1];

        if !is_valid_username(local) {
            println!("Некорректное имя пользователя: {}", local);
            continue;
        }

        local = &local.replace('.', "");
        if let Some(pos) = local.find('*') {
            local = &local[..pos];
        }

        unique_emails.insert(format!("{}@{}", local, domain));
    }

    unique_emails.len()
}

fn main() {
    let address_list1 = vec!["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
    println!("{}", email_count(address_list1));
}