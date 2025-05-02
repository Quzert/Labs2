import * as readlineSync from 'readline-sync';

function cntNonDecSeries(): number {
    let len_series: number = 0;
    let cnt: number = 0;

    const len: number = parseInt(readlineSync.question(''), 10) || 0;

    if (len > 0) {
        let num1: number = parseInt(readlineSync.question(''), 10);
        let num2: number = 0;

        for (let i: number = 1; i < len; i++) {
            num2 = parseInt(readlineSync.question(''), 10);

            if (num2 >= num1) {
                len_series++;
            } else if (len_series !== 0) {
                cnt++;
                len_series = 0;
            }
            num1 = num2;
        }

        if (len_series !== 0) {
            cnt++;
        }
    }
    return cnt;
}

const result = cntNonDecSeries();
console.log(`Количество неубывающих серий: ${result}`);