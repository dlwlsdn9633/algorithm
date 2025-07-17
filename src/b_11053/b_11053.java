package b_11053;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class b_11053 {
    private static int[] dp;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
