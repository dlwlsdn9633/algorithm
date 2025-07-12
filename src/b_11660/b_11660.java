package b_11660;

import java.io.*;
import java.util.StringTokenizer;

public class b_11660 {
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
        map = new int[N + 1][N + 1];
        dp  = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = map[i][j];
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                dp[i][j] = dp[i][j] + dp[i][j-1];
            }
        }

        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            int minRow = Math.min(row1, row2);
            int maxRow = Math.max(row1, row2);
            int minCol = Math.min(col1, col2);
            int maxCol = Math.max(col1, col2);

            int sum = 0;
            for (int row = minRow; row <= maxRow; ++row) {
                sum += dp[row][maxCol];
            }
            for (int row = minRow; row <= maxRow; ++row) {
                sum -= dp[row][minCol - 1];
            }
            bw.write(String.valueOf(sum));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
