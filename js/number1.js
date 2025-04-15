const m = 3;
const n = 3;
const s = "ULDDRRUU";

function startPosFinder(m, n, s) {
    let x = 0, y = 0;
    let rX = 0, lX = 0, uY = 0, dY = 0;

    for (const i of s) {
        if (i === "D") {
            y += 1;
            if (y > dY) dY = y;
        } else if (i === "U") {
            y -= 1;
            if (y < uY) uY = y;
        } else if (i === "L") {
            x -= 1;
            if (x < lX) lX = x;
        } else if (i === "R") {
            x += 1;
            if (x > rX) rX = x;
        }
    }

    if (rX - lX >= m || dY - uY >= n) {
        return "No";
    }
    return [1 - lX, 1 - uY];
}

console.log(startPosFinder(m, n, s));