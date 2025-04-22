import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class EmailProcessor {

    private static boolean isValidUsername(String username) {
        if (username.length() < 6 || username.length() > 30) {
            return false;
        }
        if (username.startsWith(".") || username.endsWith(".")) {
            return false;
        }
        if (username.contains("..")) {
            return false;
        }
        if (Pattern.compile("[&=+<>,_'\\-]").matcher(username).find()) {
            return false;
        }
        if (!Pattern.compile("^[a-zA-Z0-9.]*$").matcher(username).matches()) {
            return false;
        }
        return true;
    }

    public static int emailCount(List<String> emailList) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emailList) {
            String[] parts = email.split("@");
            if (parts.length != 2) {
                continue;
            }

            String local = parts[0];
            String domain = parts[1];

            if (!isValidUsername(local)) {
                System.out.println("Некорректное имя пользователя: " + local);
                continue;
            }

            local = local.replace(".", "");
            int starIndex = local.indexOf('*');
            if (starIndex != -1) {
                local = local.substring(0, starIndex);
            }

            uniqueEmails.add(local + "@" + domain);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        List<String> addressList1 = List.of("mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru");
        List<String> addressList2 = List.of("mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru");
        List<String> addressList3 = List.of("mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru");

        System.out.println(emailCount(addressList1)); // 1
        System.out.println(emailCount(addressList2)); // 1
        System.out.println(emailCount(addressList3)); // 2
    }
}