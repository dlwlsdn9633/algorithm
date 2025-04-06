package b_15684;

import java.io.*;

public class b_15684_2 {
    private static int N; // 세로선
    private static int M;
    private static int H; // 가로선
    private static int[][] map;
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        H = Integer.parseInt(conds[2]);
        map = new int[H + 1][N + 1];
        for (int m = 0; m < M; ++m) {
            String[] lineConds = br.readLine().split(" ");
            int start = Integer.parseInt(lineConds[0]);
            int end = Integer.parseInt(lineConds[1]);
            map[start][end] = 1;
        }

        search(1, 0);

        if (ret == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(ret));
        }
        bw.flush();
        bw.close();
    }
    // why? height 매개변수가 필요?
    private static void search(int fixedHeight, int depth) {
        if (depth > 3 || ret <= depth) {
            return;
        }
        if (isMatch()) {
            ret = Math.min(ret, depth);
            return;
        }
        for (int h = fixedHeight; h <= H; ++h) {
            for (int n = 1; n < N; ++n) {
                if (map[h][n] == 1) {
                    continue;
                }
                if (map[h][n + 1] == 1 || map[h][n - 1] == 1) {
                    continue;
                }
                map[h][n] = 1;
                search(h, depth + 1);
                map[h][n] = 0;
            }
        }
    }
    private static boolean isMatch() {
        for (int node = 1; node <= N; ++node) {
            int start = node;
            for (int h = 1; h <= H; ++h) {
                if (map[h][start] == 1) {
                    ++start;
                } else if (map[h][start - 1] == 1) {
                    --start;
                }
            }
            if (start != node) {
                return false;
            }
        }
        return true;
    }
}
