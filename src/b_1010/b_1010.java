package b_1010;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1010 {
    private static final long[][] dp = new long[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i <= 30; ++i) {
            Arrays.fill(dp[i], 1L);
        }
        for (int i = 2; i <= 30; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            int bigNumber = Math.max(first, last);
            int smallNumber = Math.min(first, last);

            bw.write(String.valueOf(dp[bigNumber][smallNumber]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
