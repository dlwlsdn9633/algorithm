package b_9461;

import java.io.*;

public class b_9461 {
    private static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0] = dp[1] = dp[2] = 1;
        for (int i = 3; i < 100; ++i) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int number = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[number - 1]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
