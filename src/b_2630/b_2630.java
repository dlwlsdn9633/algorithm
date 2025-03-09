package b_2630;

import java.io.IOException;
import java.util.Scanner;

public class b_2630 {
    private static int[][] square;
    private static int N;
    private static int bluePaper;
    private static int whitePaper;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        square = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                square[i][j] = scanner.nextInt();
            }
        }

        dfs(0, 0, N);
        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }
    private static void dfs(int x, int y, int n) {
        if (n == 1) {
            if (square[x][y] == 0) {
                ++whitePaper;
            } else {
                ++bluePaper;
            }
            return;
        }
        if (isFull(x, y, n)) {
            if (square[x][y] == 0) {
                ++whitePaper;
            } else {
                ++bluePaper;
            }
            return;
        }
        dfs(x, y, n / 2);
        dfs(x + (n / 2), y, n / 2);
        dfs(x + (n / 2), y + (n / 2), n / 2);
        dfs(x, y + (n / 2), n / 2);
    }
    private static boolean isFull(int x, int y, int n) {
        int firstElement = square[x][y];
        for (int i = x; i < x + n; ++i) {
            for (int j = y; j < y + n; ++j) {
                if (firstElement != square[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
