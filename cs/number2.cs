using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

class Program {
    static bool IsValidUsername(string username) {
        if (username.Length < 6 || username.Length > 30) return false;
        if (Regex.IsMatch(username, @"[&=+<>,_'\-]")) return false;
        if (username.StartsWith(".") || username.EndsWith(".")) return false;
        if (username.Contains("..")) return false;
        if (!Regex.IsMatch(username, @"^[a-zA-Z0-9.]*$")) return false;
        return true;
    }

    static int EmailCount(List<string> emailList) {
        var uniqueEmails = new HashSet<string>();

        foreach (var email in emailList) {
            var parts = email.Split('@');
            var local = parts[0];
            var domain = parts[1];

            if (!IsValidUsername(local)) {
                Console.WriteLine("Некорректное имя пользователя: " + local);
                continue;
            }

            local = local.Replace(".", "");
            if (local.Contains("*")) local = local.Split('*')[0];

            uniqueEmails.Add(local + "@" + domain);
        }

        return uniqueEmails.Count;
    }

    static void Main() {
        var addressList = new List<string> { "mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru" };
        Console.WriteLine(EmailCount(addressList));
    }
}