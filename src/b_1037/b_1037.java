package b_1037;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1037 {
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dp);
        int ret = dp[0] * dp[dp.length - 1];
        bw.write(String.valueOf(ret));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
