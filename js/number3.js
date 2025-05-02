const readlineSync = require('readline-sync');

function cntNonDecSeries() {
    let len_series = 0;
    let cnt = 0;

    const len = parseInt(readlineSync.question(''), 10) || 0;

    if (len > 0) {
        let num1 = parseInt(readlineSync.question(''), 10);
        let num2 = 0;

        for (let i = 1; i < len; i++) {
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