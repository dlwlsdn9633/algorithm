package b_1904;

import java.io.*;

public class b_1904_2 {
    private static final int MOD = 15746;
    private static final int[][] dp = new int[1_000_001][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp[1][0] = 1;
        dp[2][0] = 1; dp[2][1] = 1;
        for (int n = 3; n <= N; ++n) {
            dp[n][0] = (dp[n - 1][0] % MOD) + (dp[n - 1][1] % MOD);
            dp[n][1] = (dp[n - 2][0] % MOD) + (dp[n - 2][1] % MOD);
        }
        int sum = 0;
        for (int i = 0; i < 2; ++i) {
            sum += (dp[N][i] % MOD);
        }
        bw.write(String.valueOf(sum % MOD));

        bw.flush();
        bw.close();
        br.close();
    }
}
