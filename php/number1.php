<?php

$m = 3;
$n = 3;
$s = "ULDDRRUU";

function startPosFinder($m, $n, $s) {
    $x = 0;
    $y = 0;
    $rX = 0;
    $lX = 0;
    $uY = 0;
    $dY = 0;

    for ($i = 0; $i < strlen($s); $i++) {
        if ($s[$i] == "D") {
            $y += 1;
            if ($y > $dY) {
                $dY = $y;
            }
        } elseif ($s[$i] == "U") {
            $y -= 1;
            if ($y < $uY) {
                $uY = $y;
            }
        } elseif ($s[$i] == "L") {
            $x -= 1;
            if ($x < $lX) {
                $lX = $x;
            }
        } elseif ($s[$i] == "R") {
            $x += 1;
            if ($x > $rX) {
                $rX = $x;
            }
        }
    }

    if ($rX - $lX >= $m || $dY - $uY >= $n) {
        return "No";
    }
    return [1 - $lX, 1 - $uY];
}

print_r(startPosFinder($m, $n, $s));

?>