package b_2480;

import java.io.*;

public class b_2480 {
    private static int[] dp = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        for (String cond : conds) {
            ++dp[Integer.parseInt(cond)];
        }
        int cond = 0;
        for (int i = 1; i <= 6; ++i) {
            cond = Math.max(dp[i], cond);
        }

        int ret = 0;
        int maxValue = Integer.MIN_VALUE;
        switch (cond) {
            case 1:
                for (int i = 1; i <= 6; ++i) {
                    if (dp[i] >= 1) {
                        maxValue = i;
                    }
                }
                ret = (maxValue) * 100;
                break;
            case 2:
                for (int i = 1; i <= 6; ++i) {
                    if (dp[i] == 2) {
                        maxValue = i;
                    }
                }
                ret = 1000 + (maxValue * 100);
                break;
            case 3:
                for (int i = 1; i <= 6; ++i) {
                    if (dp[i] == 3) {
                        maxValue = i;
                    }
                }
                ret = 10000 + (maxValue * 1000);
                break;
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
