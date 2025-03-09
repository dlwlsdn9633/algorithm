package b_1992;

import java.util.Scanner;

public class b_1992 {
    private static int map[][];
    private static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        scanner.nextLine();

        map = new int[N][N];
        setMap(scanner);


        String ret = dfs(0, 0, N);
        System.out.println(ret);
    }

    private static void setMap(Scanner scanner) {
        for (int y = 0; y < N; ++y) {
            char[] row = scanner.nextLine().toCharArray();
            for (int x = 0;  x < row.length; ++x) {
                map[y][x] = Integer.valueOf(row[x] - '0');
            }
        }
    }
    private static String dfs(int y, int x, int n) {
        if (isAllSame(y, x, n)) {
            return String.valueOf(map[y][x]);
        }

        return "("
                + dfs(y, x, n / 2)
                + dfs(y, x + n / 2, n / 2)
                + dfs(y + n / 2, x, n / 2)
                + dfs(y + n / 2, x + n / 2, n / 2)
                + ")";
    }

    private static boolean isAllSame(int startY, int startX, int n) {
        int firstElement = map[startY][startX];
        for (int y = startY; y < startY + n; ++y) {
            for (int x = startX; x < startX + n; ++x) {
                if (firstElement != map[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }
}
