package b_2579;

import java.io.*;

public class b_2579_3 {
    private static int N;
    private static final int[] floors = new int[301];
    private static final int[] dp = new int[301];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; ++i) {
            floors[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = floors[1];
        dp[2] = Math.max(floors[1] + floors[2], floors[2]);
        int ret = dfs(N);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static int dfs(int depth) {
        if (depth <= 2) {
            return dp[depth];
        }
        if (dp[depth] == 0) {
            dp[depth] = Math.max(dfs(depth - 3) + floors[depth - 1], dfs(depth - 2)) + floors[depth];
        }
        return dp[depth];
    }

    /*
    private static int dfs(int depth) {
        if (depth < 0) {
            return Integer.MIN_VALUE;
        }
        dp[depth] = Math.max(dfs(depth - 3) + floors[depth - 1], dfs(depth - 2)) + floors[depth];
        return dp[depth];
    }

    */
}
