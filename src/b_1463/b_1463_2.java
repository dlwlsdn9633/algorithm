package b_1463;

import java.io.*;
import java.util.Arrays;

public class b_1463_2 {
    private final static int MAX_VALUE = 987_654_321;
    private static int[] dp;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ret = dfs(N);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static int dfs(int depth) {
        if (depth < 1) {
            return MAX_VALUE;
        }
        if (depth == 1) {
            return 0;
        }
        if (dp[depth] == Integer.MAX_VALUE) {
            if (depth % 3 == 0) {
                dp[depth] = Math.min(dp[depth], dfs(depth / 3) + 1);
            }
            if (depth % 2 == 0) {
                dp[depth] = Math.min(dp[depth], dfs(depth / 2) + 1);
            }
            dp[depth] = Math.min(dp[depth], dfs(depth - 1) + 1);
        }
        return dp[depth];
    }
}
