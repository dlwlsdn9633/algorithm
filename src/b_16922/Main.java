package b_16922;

import java.io.*;

public class Main {
    private final static int MAX_LEN = 50 * 20;
    private static int N;
    private static boolean[][] visited = new boolean[MAX_LEN + 1][21];
    private static int[] scores = { 1, 5, 10, 50 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0);

        int ret = 0;
        for (int i = 0; i <= MAX_LEN; ++i) {
            if (visited[i][N]) {
                ++ret;
            }
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            return;
        }
        for (int score : scores) {
            if ((sum + score <= MAX_LEN) && !visited[sum + score][depth + 1]) {
                visited[sum + score][depth + 1] = true;
                dfs(depth + 1, sum + score);
            }
        }
    }
}
