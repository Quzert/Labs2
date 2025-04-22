function countNonDecreasingSeries(sequence: string): number {
    let cnt = 0;
    const n = sequence.length;
    let i = 0;

    while (i < n - 1) {
        if (sequence[i] <= sequence[i + 1]) {
            cnt += 1;
            while (i < n - 1 && sequence[i] <= sequence[i + 1]) {
                i += 1;
            }
        } else {
            i += 1;
        }
    }

    return cnt;
}

const sequence1 = "512325";
console.log(`Количество неубывающих серий №1: ${countNonDecreasingSeries(sequence1)}`);

const sequence2 = "484756344";
console.log(`Количество неубывающих серий №2: ${countNonDecreasingSeries(sequence2)}`);

const sequence3 = "12345678998765432123456789987654321";
console.log(`Количество неубывающих серий №3: ${countNonDecreasingSeries(sequence3)}`);