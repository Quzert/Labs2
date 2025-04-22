fn count_non_decreasing_series(sequence: &str) -> i32 {
    let mut cnt = 0;
    let chars: Vec<char> = sequence.chars().collect();
    let n = chars.len();
    let mut i = 0;

    while i < n - 1 {
        if chars[i] <= chars[i + 1] {
            cnt += 1;
            while i < n - 1 && chars[i] <= chars[i + 1] {
                i += 1;
            }
        } else {
            i += 1;
        }
    }
    cnt
}

fn main() {
    let sequence1 = "512325";
    println!("Количество неубывающих серий №1: {}", count_non_decreasing_series(sequence1));

    let sequence2 = "484756344";
    println!("Количество неубывающих серий №2: {}", count_non_decreasing_series(sequence2));

    let sequence3 = "12345678998765432123456789987654321";
    println!("Количество неубывающих серий №3: {}", count_non_decreasing_series(sequence3));
}