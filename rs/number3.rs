fn count_non_decreasing_series(sequence: &[i32]) -> i32 {
    let mut cnt = 0;
    let n = sequence.len();
    let mut i = 0;
    while i < n - 1 {
        if sequence[i] <= sequence[i + 1] {
            cnt += 1;
            while i < n - 1 && sequence[i] <= sequence[i + 1] {
                i += 1;
            }
        } else {
            i += 1;
        }
    }
    cnt
}

fn str_to_list(s: &str) -> Vec<i32> {
    s.chars().map(|c| c.to_digit(10).unwrap() as i32).collect()
}

fn main() {
    let sequence1 = vec![5, 1, 2, 3, 2, 5];
    println!("Количество неубывающих серий №1: {}", count_non_decreasing_series(&sequence1));

    let sequence2 = str_to_list("484756344");
    println!("Количество неубывающих серий №2: {}", count_non_decreasing_series(&sequence2));

    let sequence3 = str_to_list("12345678998765432123456789987654321");
    println!("Количество неубывающих серий №3: {}", count_non_decreasing_series(&sequence3));
}