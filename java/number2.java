// Java
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

class EmailCounter {

    private static final Pattern FORBIDDEN_CHARS = Pattern.compile("[&=+<>,_'-]");
    private static final Pattern ALLOWED_CHARS = Pattern.compile("^[a-zA-Z0-9.*]*$");

    // Проверка имени пользователя на соответствие правилам
    private static boolean isValidUsername(String username) {
        if (username.length() < 6 || username.length() > 30) return false;
        if (FORBIDDEN_CHARS.matcher(username).find()) return false;
        if (username.startsWith(".") || username.endsWith(".")) return false;
        if (username.contains("..")) return false;
        if (!ALLOWED_CHARS.matcher(username).matches()) return false;
        return true;
    }

    public static int emailCount(List<String> emailList) {
        // Используем Set для хранения уникальных нормализованных адресов
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emailList) {
            int atPos = email.indexOf('@');
            if (atPos <= 0 || atPos == email.length() - 1) {
                continue;
            }

            String local = email.substring(0, atPos);
            String domain = email.substring(atPos + 1);

            // Сначала валидируем оригинальное имя пользователя
            if (!isValidUsername(local)) {
                continue;
            }

            // Нормализация: убираем все после '*' и удаляем все '.'
            int starPos = local.indexOf('*');
            if (starPos != -1) {
                local = local.substring(0, starPos);
            }
            String cleanedLocal = local.replace(".", "");

            uniqueEmails.add(cleanedLocal + "@" + domain);
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        List<String> addressList1 = List.of("mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru");
        List<String> addressList2 = List.of("mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru");
        List<String> addressList3 = List.of("mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru");

        System.out.println("List 1 Count: " + emailCount(addressList1));
        System.out.println("List 2 Count: " + emailCount(addressList2));
        System.out.println("List 3 Count: " + emailCount(addressList3));
    }
}