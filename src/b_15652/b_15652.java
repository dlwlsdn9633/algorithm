package b_15652;

import java.io.*;
import java.util.StringTokenizer;

public class b_15652 {
    private static int end;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        end = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        dp = new int[len];
        dfs(0, 1, bw);

        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int depth, int start, BufferedWriter bw) throws IOException {
        if (depth >= dp.length) {
            for (int num : dp) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }
        for (int num = start; num <= end; ++num) {
            dp[depth] = num;
            dfs(depth + 1, num, bw);
        }
    }
}
