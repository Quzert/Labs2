const m = 3;
const n = 3;
const s = "ULDDRRUU";

function startPosFinder(m: number, n: number, s: string): any {
    let x = 0;
    let y = 0;
    let rX = 0;
    let lX = 0;
    let uY = 0;
    let dY = 0;

    for (const i of s) {
        switch (i) {
            case 'D':
                y += 1;
                if (y > dY) dY = y;
                break;
            case 'U':
                y -= 1;
                if (y < uY) uY = y;
                break;
            case 'L':
                x -= 1;
                if (x < lX) lX = x;
                break;
            case 'R':
                x += 1;
                if (x > rX) rX = x;
                break;
        }
    }

    if (rX - lX >= m || dY - uY >= n) {
        return "No";
    } else {
        return [1 - lX, 1 - uY];
    }
}

console.log(startPosFinder(m, n, s));