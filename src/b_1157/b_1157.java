package b_1157;

import java.io.*;
import java.util.Arrays;

public class b_1157 {
    private static int[] dp = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                ++dp[c - 'a'];
            }
            if (c >= 'A' && c <= 'Z') {
                ++dp[c - 'A'];
            }
        }

        char ret = 0;
        int maxValue = Arrays.stream(dp).max().getAsInt();
        int totalNumber = 0;

        for (int i = 0; i < dp.length; ++i) {
            if (dp[i] == maxValue) {
                ++totalNumber;
                ret = (char)(i + 'A');
            }
        }
        if (totalNumber > 1) {
            bw.write("?");
        } else {
            bw.write(ret);
        }
        bw.flush();
        bw.close();
    }
}
