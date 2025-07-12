package b_10844;


import java.io.*;

public class b_10844 {
    private static final long MOD = 1000000000;
    private static int N;
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];
        for (int num = 0; num <= 9; ++num) {
            dp[1][num] = 1L;
        }
        for (int num = 2; num <= N; ++num) {
            dp[num][0] = dp[num - 1][1] % MOD;
            for (int i = 1; i <= 8; ++i) {
                dp[num][i] = ((dp[num - 1][i - 1] % MOD) + (dp[num - 1][i + 1] % MOD)) % MOD;
            }
            dp[num][9] = (dp[num - 1][8]) % MOD;
        }

        long sum = 0L;
        for (int num = 1; num <= 9; ++num) {
            sum += (dp[N][num]) % MOD;
            sum %= MOD;
        }
        bw.write(String.valueOf(sum % MOD));

        bw.flush();
        bw.close();
        br.close();
    }
}
