using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

class Program {
    static bool IsValidUsername(string username) {
        if (username.Length < 6 || username.Length > 30) return false;
        if (Regex.IsMatch(username, @"[&=+<>,_'\-]")) return false;
        if (username.StartsWith(".") || username.EndsWith(".")) return false;
        if (username.Contains("..")) return false;
        return true;
    }

    static int EmailCount(List<string> emailList) {
        var uniqueEmails = new HashSet<string>();

        foreach (var email in emailList) {
            var parts = email.Split('@');
            if (parts.Length != 2) {
                Console.WriteLine("Некорректный email: " + email);
                continue;
            }

            var local = parts[0];
            var domain = parts[1];

            if (!IsValidUsername(local)) {
                Console.WriteLine("Некорректное имя пользователя: " + local);
                continue;
            }

            local = local.Replace(".", "");
            int starIndex = local.IndexOf('*');
            if (starIndex != -1) {
                local = local.Substring(0, starIndex);
            }
            if (!Regex.IsMatch(local, @"^[a-zA-Z0-9.]*$")){
                Console.WriteLine("Некорректное имя пользователя: " + local);
                continue;
            }

            uniqueEmails.Add(local + "@" + domain);
        }

        return uniqueEmails.Count;
    }

    static void Main() {
        var addressList1 = new List<string> { "mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru" };
        Console.WriteLine(EmailCount(addressList1));
        var addressList2 = new List<string> { "mar.phascience@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru" };
        Console.WriteLine(EmailCount(addressList2));
        var addressList3 = new List<string> { "mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru" };
        Console.WriteLine(EmailCount(addressList3));
    }
}