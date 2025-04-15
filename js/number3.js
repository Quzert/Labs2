function countNonDecreasingSeries(sequence) {
    let cnt = 0;
    const n = sequence.length;
    let i = 0;

    while (i < n - 1) {
        if (sequence[i] <= sequence[i + 1]) {
            cnt++;
            while (i < n - 1 && sequence[i] <= sequence[i + 1]) {
                i++;
            }
        } else {
            i++;
        }
    }

    return cnt;
}

function strToList(s) {
    return Array.from(s);
}

const sequence1 = [5, 1, 2, 3, 2, 5];
console.log(`Количество неубывающих серий №1: ${countNonDecreasingSeries(sequence1)}`);

const sequence2 = strToList("484756344");
console.log(`Количество неубывающих серий №2: ${countNonDecreasingSeries(sequence2)}`);

const sequence3 = strToList("12345678998765432123456789987654321");
console.log(`Количество неубывающих серий №3: ${countNonDecreasingSeries(sequence3)}`);