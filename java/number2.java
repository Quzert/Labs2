import java.util.HashSet;
import java.util.Set;

public class Number2 {
    public static int emailCount(String[] emailList) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emailList) {
            String[] parts = email.split("@");
            String local = parts[0].replace(".", "");
            if (local.contains("+")) {
                local = local.split("\\+")[0];
            }
            uniqueEmails.add(local + "@" + parts[1]);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        String[] addressList1 = {"mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"};
        String[] addressList2 = {"mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"};
        String[] addressList3 = {"mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"};

        System.out.println(emailCount(addressList1)); // 1
        System.out.println(emailCount(addressList2)); // 1
        System.out.println(emailCount(addressList3)); // 2
    }
}