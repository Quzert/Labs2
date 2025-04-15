using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        var addressList1 = new List<string> { "mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru" };
        var addressList2 = new List<string> { "mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru" };
        var addressList3 = new List<string> { "mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru" };

        Console.WriteLine(EmailCount(addressList1)); // 1
        Console.WriteLine(EmailCount(addressList2)); // 1
        Console.WriteLine(EmailCount(addressList3)); // 2
    }

    static int EmailCount(List<string> emailList)
    {
        var uniqueEmails = new HashSet<string>();

        foreach (var email in emailList)
        {
            var parts = email.Split('@');
            var local = parts[0].Replace(".", "");
            if (local.Contains("+"))
            {
                local = local.Split('+')[0];
            }
            uniqueEmails.Add(local + "@" + parts[1]);
        }

        return uniqueEmails.Count;
    }
}