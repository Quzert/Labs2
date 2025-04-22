public class Number3 {
    public static int countNonDecreasingSeries(String sequence) {
        int cnt = 0;
        int n = sequence.length();
        int i = 0;

        while (i < n - 1) {
            if (sequence.charAt(i) <= sequence.charAt(i + 1)) {
                cnt++;
                while (i < n - 1 && sequence.charAt(i) <= sequence.charAt(i + 1)) {
                    i++;
                }
            } else {
                i++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        String sequence1 = "512325";
        System.out.println("Количество неубывающих серий №1: " + countNonDecreasingSeries(sequence1));

        String sequence2 = "484756344";
        System.out.println("Количество неубывающих серий №2: " + countNonDecreasingSeries(sequence2));

        String sequence3 = "12345678998765432123456789987654321";
        System.out.println("Количество неубывающих серий №3: " + countNonDecreasingSeries(sequence3));
    }
}