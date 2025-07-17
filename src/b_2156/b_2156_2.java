package b_2156;

import java.io.*;
import java.util.Arrays;

public class b_2156_2 {
    private final static int MAX_LEN = 10_001;
    private static int N;
    private static int ret = Integer.MIN_VALUE;
    private final static int[] arr = new int[MAX_LEN];
    private final static int[] dp = new int[MAX_LEN];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        ret = dp[1];
        dp[2] = arr[1] + arr[2];
        ret = Math.max(ret, dp[2]);
        for (int i = 3; i <= N; ++i) {
            dp[i] = dp[i - 2];
            for (int j = i - 3; j >= 0; --j) {
                dp[i] = Math.max(dp[i], dp[j] + arr[i - 1]);
            }
            dp[i] += arr[i];
            ret = Math.max(ret, dp[i]);
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
