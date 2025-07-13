package b_2156;

import java.io.*;

public class b_2156 {
    private static int N;
    private final static int[] floors = new int[10_001];
    private final static int[] dp = new int[10_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; ++n) {
            floors[n] = Integer.parseInt(br.readLine());
        }
        dp[1] = floors[1];
        int ret = dp[1];
        dp[2] = floors[1] + floors[2];
        ret = Math.max(ret, dp[2]);
        for (int n = 3; n <= N; ++n) {
            dp[n] = dp[n - 2];
            for (int i = n - 3; i >= 0; --i) {
                dp[n] = Math.max(
                        dp[n],
                        dp[i] + floors[n - 1]
                );
            }
            dp[n] += floors[n];
            ret = Math.max(dp[n], ret);
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }

}
