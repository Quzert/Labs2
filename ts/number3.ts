function countNonDecreasingSeries(sequence: number[]): number {
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

function strToList(s: string): number[] {
    return Array.from(s).map(Number);
}

const sequence1 = [5, 1, 2, 3, 2, 5];
console.log(`Количество неубывающих серий №1: ${countNonDecreasingSeries(sequence1)}`);

const sequence2 = strToList("484756344");
console.log(`Количество неубывающих серий №2: ${countNonDecreasingSeries(sequence2)}`);

const sequence3 = strToList("12345678998765432123456789987654321");
console.log(`Количество неубывающих серий №3: ${countNonDecreasingSeries(sequence3)}`);