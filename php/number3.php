<?php

function count_non_decreasing_series($sequence) {
    $cnt = 0;
    $n = strlen($sequence);
    $i = 0;
    while ($i < $n - 1) {
        if ($sequence[$i] <= $sequence[$i + 1]) {
            $cnt++;
            while ($i < $n - 1 && $sequence[$i] <= $sequence[$i + 1]) {
                $i++;
            }
        } else {
            $i++;
        }
    }
    return $cnt;
}

$sequence1 = "512325";
echo "Количество неубывающих серий №1: " . count_non_decreasing_series($sequence1) . "\n";

$sequence2 = "484756344";
echo "Количество неубывающих серий №2: " . count_non_decreasing_series($sequence2) . "\n";

$sequence3 = "12345678998765432123456789987654321";
echo "Количество неубывающих серий №3: " . count_non_decreasing_series($sequence3) . "\n";

?>