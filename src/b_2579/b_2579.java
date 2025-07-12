package b_2579;

import java.io.*;
import java.util.Arrays;

public class b_2579 {
    private static int[] floors;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        floors = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i < floors.length; ++i) {
            floors[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0);


        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int floor, int walk) {
        if (floor >= floors.length || walk == 3) {
            return Integer.MIN_VALUE;
        }
        if (floor == floors.length - 1) {
            return 0;
        }
        int ret = dp[floor];
        if (ret != 0) {
            return ret;
        }


        ret = Math.max(
                dfs(floor + 1, walk + 1) + floors[floor],
                dfs(floor + 2, 0) + floors[floor]
        );
        dp[floor] = ret;
        return ret;
    }
}
