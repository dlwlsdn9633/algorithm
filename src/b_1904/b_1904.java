package b_1904;

import java.io.*;

public class b_1904 {
    private static final int MAX_SIZE = 1_000_001;
    private static final int MOD = 15746;
    private static final int[][] dp = new int[MAX_SIZE][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp[1][0] = 1; dp[1][1] = 0;
        dp[2][0] = 1; dp[2][1] = 1;
        for (int i = 3; i <= N; ++i) {
            dp[i][0] = ((dp[i - 1][0] % MOD) + (dp[i - 1][1] % MOD)) % MOD;
            dp[i][1] = ((dp[i - 2][0] % MOD) + (dp[i - 2][1] % MOD)) % MOD;
        }
        int ret = ((dp[N][0] % MOD) + (dp[N][1] % MOD)) % MOD;
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
