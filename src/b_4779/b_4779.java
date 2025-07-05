package b_4779;

import java.io.*;
import java.util.Arrays;

public class b_4779 {
    private static char[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb;
        String number = "";
        while ((number = br.readLine()) != null) {
            int N = Integer.parseInt(number);
            sb = new StringBuilder();

            int len = (int)Math.pow(3, N);
            dp = new char[len];
            Arrays.fill(dp, '-');
            dfs(0, len);
            for (char c : dp) {
                sb.append(c);
            }
            System.out.println(sb);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start, int end) {
        if (end - start == 1) {
            dp[start] = '-';
            return;
        }
        int interval = (end - start) / 3;
        dfs(start, start + interval);
        for (int i = start + interval; i < start + (2 * interval); ++i) {
            dp[i] = ' ';
        }
        dfs(start + (2 * interval), end);
    }
}
