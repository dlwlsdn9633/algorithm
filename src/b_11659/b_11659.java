package b_11659;

import java.io.*;
import java.util.StringTokenizer;

public class b_11659 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; ++i) {
            dp[i] = dp[i - 1] + arr[i];
        }
        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(dp[j] - dp[i - 1]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
