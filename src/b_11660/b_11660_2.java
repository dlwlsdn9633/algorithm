package b_11660;

import java.io.*;
import java.util.StringTokenizer;

public class b_11660_2 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = map[i][j];
            }
        }
        for (int i = 1; i <= N; ++i) {
            dp[0][i] = dp[0][i] + dp[0][i - 1];
            dp[i][0] = dp[i][0] + dp[i - 1][0];
        }


        

        bw.flush();
        bw.close();
        br.close();
    }
}
