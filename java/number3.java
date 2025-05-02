import java.util.Scanner;

public class CountSeriesFuncNoComments {

    public static int cntNonDecSeries(Scanner scanner) {
        int len_series = 0;
        int cnt = 0;

        int len = scanner.nextInt();

        if (len > 0) {
            int num1 = scanner.nextInt();
            int num2 = 0;

            for (int i = 1; i < len; i++) {
                num2 = scanner.nextInt();
                if (num2 >= num1) {
                    len_series++;
                } else if (len_series != 0) {
                    cnt++;
                    len_series = 0;
                }
                num1 = num2;
            }

            if (len_series != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = cntNonDecSeries(scanner);
        System.out.println("Количество неубывающих серий: " + result);
        scanner.close();
    }
}