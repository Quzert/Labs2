public class Number1 {
    public static Object startPosFinder(int m, int n, String s) {
        int x = 0, y = 0;
        int rX = 0, lX = 0, uY = 0, dY = 0;

        for (char i : s.toCharArray()) {
            switch (i) {
                case 'D':
                    y += 1;
                    if (y > dY) dY = y;
                    break;
                case 'U':
                    y -= 1;
                    if (y < uY) uY = y;
                    break;
                case 'L':
                    x -= 1;
                    if (x < lX) lX = x;
                    break;
                case 'R':
                    x += 1;
                    if (x > rX) rX = x;
                    break;
            }
        }

        if (rX - lX >= m || dY - uY >= n) {
            return "No";
        } else {
            return new int[]{1 - lX, 1 - uY};
        }
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        String s = "ULDDRRUU";

        Object result = startPosFinder(m, n, s);
        if (result instanceof String) {
            System.out.println(result);
        } else {
            int[] position = (int[]) result;
            System.out.println("[" + position[0] + ", " + position[1] + "]");
        }
    }
}