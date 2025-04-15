<?php

$addres_list1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];  // 1
$addres_list2 = ["mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];  // 1
$addres_list3 = ["mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"];  // 2

function email_count($email_list) {
    $unique_emails = [];

    foreach ($email_list as $email) {
        list($local, $domain) = explode('@', $email);
        $local = str_replace('.', '', $local);
        if (strpos($local, '+') !== false) {
            $local = substr($local, 0, strpos($local, '+'));  // Удаляем часть после '+'
        }
        $unique_emails[$local . '@' . $domain] = true;
    }

    return count($unique_emails);
}

echo email_count($addres_list1) . "\n";  // 1
echo email_count($addres_list2) . "\n";  // 1
echo email_count($addres_list3) . "\n";  // 2

?>