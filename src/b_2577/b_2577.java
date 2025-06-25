package b_2577;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n1 = Long.parseLong(br.readLine());
        long n2 = Long.parseLong(br.readLine());
        long n3 = Long.parseLong(br.readLine());
        long ret = n1 * n2 * n3;
        String strRet = String.valueOf(ret);

        int[] dp = new int[10];
        Arrays.fill(dp, 0);
        for (char strEle : strRet.toCharArray()) {
            ++dp[strEle - '0'];
        }
        for (int ele : dp) {
            bw.write(String.valueOf(ele));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
