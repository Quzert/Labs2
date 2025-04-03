<?php

function count_non_decreasing_series($sequence) {
    $cnt = 0;
    $n = count($sequence);
    $i = 0;
    while ($i < $n - 1) {
        if ($sequence[$i] <= $sequence[$i + 1]) {
            $cnt += 1;
            while ($i < $n - 1 && $sequence[$i] <= $sequence[$i + 1]) {
                $i += 1;
            }
        } else {
            $i += 1;
        }
    }
    return $cnt;
}

function str_to_list($s) {
    return str_split($s);
}

$sequence1 = [5, 1, 2, 3, 2, 5];
echo "Количество неубывающих серий №1: " . count_non_decreasing_series($sequence1) . "\n";

$sequence2 = str_to_list("484756344");
echo "Количество неубывающих серий №2: " . count_non_decreasing_series($sequence2) . "\n";

$sequence3 = str_to_list("12345678998765432123456789987654321");
echo "Количество неубывающих серий №3: " . count_non_decreasing_series($sequence3) . "\n";

?>