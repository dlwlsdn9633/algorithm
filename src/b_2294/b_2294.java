package b_2294;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2294 {
    private final static int INF = 987_654_321;
    private static int N;
    private static int K;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int n = 0; n < N; ++n) {
            int coin = Integer.parseInt(br.readLine());
            for (int i = coin; i <= K; ++i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[K] == INF) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(dp[K]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
