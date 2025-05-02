use std::io;

fn cnt_non_dec_series() -> i32 {
    let mut len_series = 0;
    let mut cnt = 0;

    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let len: usize = input.trim().parse().unwrap();

    let mut num1 = {
        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        input.trim().parse::<i32>().unwrap()
    };

    let mut i = 1;
    while i < len {
        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let num2 = input.trim().parse::<i32>().unwrap();

        if num2 >= num1 {
            len_series += 1;
            num1 = num2;
        } else if len_series != 0 {
            cnt += 1;
            len_series = 0;
        }
        i += 1;
    }

    if len_series != 0 {
        cnt += 1;
    }

    cnt
}

fn main() {
    println!("Введите количество чисел и саму последовательность:");
    println!("Количество неубывающих серий: {}", cnt_non_dec_series());
}