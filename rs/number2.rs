
use std::collections::HashSet;

fn is_valid_username_rs(username: &str) -> bool {
    let len = username.len();
    if !(6..=30).contains(&len) { return false; }

    if username.contains(|c: char| "& =+<>,_'-".contains(c)) { return false; }

    if username.starts_with('.') || username.ends_with('.') { return false; }

    if username.contains("..") { return false; }

    if !username.chars().all(|c| c.is_ascii_alphanumeric() || c == '.' || c == '*') { return false; }

    true
}

fn email_count_rs(email_list: &[&str]) -> usize {

    let mut unique_emails: HashSet<String> = HashSet::new();

    for email in email_list {
        if let Some(at_pos) = email.find('@') {
            if at_pos == 0 || at_pos == email.len() - 1 {
                 continue;
            }

            let local_part = &email[..at_pos];
            let domain_part = &email[at_pos + 1..];

            if !is_valid_username_rs(local_part) {
                continue;
            }

            let final_local = match local_part.find('*') {
                Some(star_pos) => &local_part[..star_pos],
                None => local_part,
            };
            let cleaned_local: String = final_local.chars().filter(|&c| c != '.').collect();

            unique_emails.insert(format!("{}@{}", cleaned_local, domain_part));
        }
    }
    unique_emails.len()
}

fn main() {
    let address_list1 = vec!["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
    let address_list2 = vec!["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"];
    let address_list3 = vec!["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"];

    println!("List 1 Count: {}", email_count_rs(&address_list1));
    println!("List 2 Count: {}", email_count_rs(&address_list2));
    println!("List 3 Count: {}", email_count_rs(&address_list3));
}