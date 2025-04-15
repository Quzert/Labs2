import java.util.ArrayList;
import java.util.List;

public class Number3 {
    public static int countNonDecreasingSeries(List<Integer> sequence) {
        int cnt = 0;
        int n = sequence.size();
        int i = 0;

        while (i < n - 1) {
            if (sequence.get(i) <= sequence.get(i + 1)) {
                cnt++;
                while (i < n - 1 && sequence.get(i) <= sequence.get(i + 1)) {
                    i++;
                }
            } else {
                i++;
            }
        }

        return cnt;
    }

    public static List<Integer> strToList(String s) {
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> sequence1 = List.of(5, 1, 2, 3, 2, 5);
        System.out.println(countNonDecreasingSeries(sequence1));

        List<Integer> sequence2 = strToList("484756344");
        System.out.println(countNonDecreasingSeries(sequence2));

        List<Integer> sequence3 = strToList("12345678998765432123456789987654321");
        System.out.println(countNonDecreasingSeries(sequence3));
    }
}