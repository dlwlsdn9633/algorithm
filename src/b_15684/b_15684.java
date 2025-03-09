package b_15684;

import java.io.*;

public class b_15684 {
    private static int N;
    private static int M;
    private static int H;
    private static boolean visited[][] = new boolean[34][34];
    private static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        H = Integer.parseInt(conds[2]);

        for (int i = 0; i < M; ++i) {
            String[] rows = br.readLine().split(" ");
            int h = Integer.parseInt(rows[0]);
            int n = Integer.parseInt(rows[1]);
            visited[h][n] = true;
        }
        dfs(1, 0);
        if (minValue == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(minValue));
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int here, int selectDepth) {
        if (selectDepth > 3 || selectDepth >= minValue) {
            return;
        }
        if (check()) {
            minValue = Math.min(minValue, selectDepth);
            return;
        } else {
            for (int h = here; h <= H; ++h) {
                for (int n = 1; n < N ; ++n) {
                    if (visited[h][n]) {
                        continue;
                    }
                    if (visited[h][n - 1]) {
                        continue;
                    }
                    if (visited[h][n + 1]) {
                        continue;
                    }
                    visited[h][n] = true;
                    dfs(h, selectDepth + 1);
                    visited[h][n] = false;
                }
            }
        }
    }
    private static boolean check() {
        for (int n = 1; n <= N; ++n) {
            int start = n;
            for (int h = 1; h <= H; ++h) {
                if (visited[h][start]) {
                    ++start;
                }
                else if (visited[h][start - 1]) {
                    --start;
                }
            }
            if (start != n) {
                return false;
            }
        }
        return true;
    }
}
