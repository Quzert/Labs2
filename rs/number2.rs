use std::collections::HashSet;

fn email_count(email_list: Vec<&str>) -> usize {
    let mut unique_emails = HashSet::new();

    for email in email_list {
        let parts: Vec<&str> = email.split('@').collect();
        let mut local = parts[0].replace('.', "");
        if let Some(pos) = local.find('+') {
            local = local[..pos].to_string();
        }
        let domain = parts[1];
        unique_emails.insert(format!("{}@{}", local, domain));
    }

    unique_emails.len()
}

fn main() {
    let addres_list1 = vec!["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
    let addres_list2 = vec!["mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];
    let addres_list3 = vec!["mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];

    println!("{}", email_count(addres_list1));  // 1
    println!("{}", email_count(addres_list2));  // 1
    println!("{}", email_count(addres_list3));  // 2
}