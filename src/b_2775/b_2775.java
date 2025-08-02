package b_2775;

import java.io.*;

public class b_2775 {
    private final static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int j = 0; j <= 14; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= 14; ++i) {
            for (int j = 1; j <= 14; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int floor = Integer.parseInt(br.readLine());
            int person = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[floor][person]));
            bw.newLine();
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
