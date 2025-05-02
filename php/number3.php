<?php
error_reporting(0);

function cnt_non_dec_series(): int {
    $len_series = 0;
    $cnt = 0;

    $len = (int)trim(fgets(STDIN));

    if ($len > 0) {
        $num1 = (int)trim(fgets(STDIN));
        $num2 = 0;

        for ($i = 1; $i < $len; $i++) {
            $num2 = (int)trim(fgets(STDIN));

            if ($num2 >= $num1) {
                $len_series++;
            } else if ($len_series != 0) {
                $cnt++;
                $len_series = 0;
            }
            $num1 = $num2;
        }

        if ($len_series != 0) {
            $cnt++;
        }
    }
    return $cnt;
}

$result = cnt_non_dec_series();
echo "Количество неубывающих серий: " . $result . "\n";

?>