package b_2579;

import java.io.*;

public class b_2579_4 {
    private static final int MAX_VALUE = 301;
    private static final int[] floors = new int[MAX_VALUE];
    private static final int[] dp = new int[MAX_VALUE];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; ++n) {
            floors[n] = Integer.parseInt(br.readLine());
        }
        dp[1] = floors[1];
        dp[2] = Math.max(floors[2], floors[1] + floors[2]);
        for (int n = 3; n <= N; ++n) {
            dp[n] = Math.max(dp[n - 2], dp[n - 3] + floors[n - 1]) + floors[n];
        }
        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
        br.close();
    }
}
