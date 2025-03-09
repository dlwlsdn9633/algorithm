package b_2178;

import java.util.Scanner;

public class b_2178_dfs {
    private static int N;
    private static int M;
    private static int depthMap[][];
    private static int map[][];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        N = Integer.valueOf(str[0]);
        M = Integer.valueOf(str[1]);

        map = new int[N + 1][M + 1];
        depthMap = new int[N + 1][M + 1];

        for (int i = 1; i <= N; ++i) {
            String row = scanner.nextLine();
            char[] rowArr = row.toCharArray();

            for (int j = 0; j < M; ++j) {
                //System.out.println(rowArr[j]);
                map[i][j + 1] = rowArr[j] - '0';
            }

            for (int j = 1; j <= M; ++j) {
                depthMap[i][j] = Integer.MAX_VALUE;
            }
        }

        dfs(1, 1, 1);
        System.out.println(depthMap[N][M]);
    }

    private static void dfs(int x, int y, int depth) {
        if (x < 1 || y < 1 || x > N || y > M) {
            return;
        }

        if (map[x][y] == 0) {
            return;
        }

        if (depth < depthMap[x][y]) {
            depthMap[x][y] = depth;

            dfs(x + 1, y, depth + 1);
            dfs(x, y + 1, depth + 1);
            dfs(x - 1, y, depth + 1);
            dfs(x, y - 1, depth + 1);
        }
    }
}
