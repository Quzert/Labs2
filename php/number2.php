<?php
function isValidUsernamePhp($username) {
    $len = strlen($username);
    if ($len < 6 || $len > 30) return false;
    if (preg_match('/[&\\=\\+<>,_\'-]/', $username)) return false;
    if ($username[0] === '.' || $username[$len - 1] === '.') return false;
    if (strpos($username, '..') !== false) return false;
    if (!preg_match('/^[a-zA-Z0-9.*]*$/', $username)) return false;
    return true;
}

function emailCountPhp(array $emailList): int {
    // Используем ключи массива для хранения уникальных нормализованных адресов
    $uniqueEmails = [];

    foreach ($emailList as $email) {
        $atPos = strpos($email, '@');
        if ($atPos === false || $atPos === 0 || $atPos === strlen($email) - 1) {
            continue;
        }

        $local = substr($email, 0, $atPos);
        $domain = substr($email, $atPos + 1);

        // Сначала валидируем оригинальное имя пользователя
        if (!isValidUsernamePhp($local)) {
            continue;
        }

        // Нормализация: убираем все после '*' и удаляем все '.'
        $starPos = strpos($local, '*');
        if ($starPos !== false) {
            $local = substr($local, 0, $starPos);
        }
        $cleanedLocal = str_replace('.', '', $local);

        $normalizedEmail = $cleanedLocal . "@" . $domain;
        $uniqueEmails[$normalizedEmail] = true;
    }
    return count($uniqueEmails);
}

// Example Usage:
$addressList1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
$addressList2 = ["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"];
$addressList3 = ["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"];

echo "List 1 Count: " . emailCountPhp($addressList1) . "\n";
echo "List 2 Count: " . emailCountPhp($addressList2) . "\n";
echo "List 3 Count: " . emailCountPhp($addressList3) . "\n";

?>