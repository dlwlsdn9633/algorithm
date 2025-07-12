package b_2579;

import java.io.*;
import java.util.Arrays;

public class b_2579_2 {
    private static int N;
    private static int[] floors;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        floors = new int[N + 1];
        dp = new int[N + 1];
        for (int floor = 1; floor <= N; ++floor) {
            floors[floor] = Integer.parseInt(br.readLine());
        }
        int ret = dfs(0, 0);
        bw.write(String.valueOf(ret));


        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int depth, int walk) {
        if (depth >= floors.length || walk == 3) {
            return Integer.MIN_VALUE;
        }
        if (depth == floors.length - 1) {
            return floors[depth];
        }

        int ret = dp[depth];
        if (ret != 0) {
            if (walk + 1 == 3) {
                return Integer.MIN_VALUE;
            }
            return dp[depth];
        }
        ret = Math.max(
                dfs(depth + 1, walk + 1) + floors[depth],
                dfs(depth + 2, 1) + floors[depth]
        );
        ret = Math.max(dp[depth], ret);
        dp[depth] = ret;
        System.out.println(Arrays.toString(dp));
        return ret;
    }
}
