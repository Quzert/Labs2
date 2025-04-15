fn start_pos_finder(m: i32, n: i32, s: &str) -> String {
    let (mut x, mut y) = (0, 0);
    let (mut r_x, mut l_x) = (0, 0);
    let (mut u_y, mut d_y) = (0, 0);

    for c in s.chars() {
        match c {
            'D' => {
                y += 1;
                if y > d_y {
                    d_y = y;
                }
            }
            'U' => {
                y -= 1;
                if y < u_y {
                    u_y = y;
                }
            }
            'L' => {
                x -= 1;
                if x < l_x {
                    l_x = x;
                }
            }
            'R' => {
                x += 1;
                if x > r_x {
                    r_x = x;
                }
            }
            _ => {}
        }
    }

    if r_x - l_x >= m || d_y - u_y >= n {
        return "No".to_string();
    }
    format!("{} {}", 1 - l_x, 1 - u_y)
}

fn main() {
    let m = 3;
    let n = 3;
    let s = "ULDDRRUU";
    println!("{}", start_pos_finder(m, n, s));
}