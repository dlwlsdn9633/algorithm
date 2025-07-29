package b_12865;

import java.io.*;
import java.util.StringTokenizer;
public class b_12865_2 {
    private static int N;
    private static int K;
    private static int[][] dp;
    private static int[] weights;
    private static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        for (int n = 1; n <= N; ++n) {
            for (int k = 0; k <= K; ++k) {
                if (weights[n] > k) {
                    dp[n][k] = dp[n - 1][k];
                } else {
                    dp[n][k] = Math.max(dp[n - 1][k], dp[n - 1][k - weights[n]] + values[n]);
                }
            }
        }
        bw.write(String.valueOf(dp[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weights = new int[N + 1];
        values = new int[N + 1];
        dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
    }
}
