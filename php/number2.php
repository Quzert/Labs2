<?php

function is_valid_username($username) {
    if (strlen($username) < 6 || strlen($username) > 30) {
        return false;
    }

    if (preg_match('/[&=+<>,_\'\-]/', $username)) {
        return false;
    }

    if ($username[0] === '.' || $username[strlen($username) - 1] === '.') {
        return false;
    }

    if (strpos($username, '..') !== false) {
        return false;
    }

    if (!preg_match('/^[a-zA-Z0-9.]*$/', $username)) {
        return false;
    }

    return true;
}

function email_count($email_list) {
    $unique_emails = [];

    foreach ($email_list as $email) {
        list($local, $domain) = explode('@', $email);

        if (!is_valid_username($local)) {
            echo "Некорректное имя пользователя: $local\n";
            continue;
        }

        $local = str_replace('.', '', $local);
        if (strpos($local, '*') !== false) {
            $local = substr($local, 0, strpos($local, '*'));
        }

        $unique_emails[$local . '@' . $domain] = true;
    }

    return count($unique_emails);
}

$address_list1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"];
echo email_count($address_list1) . "\n";
?>