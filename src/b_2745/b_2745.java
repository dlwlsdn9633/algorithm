package b_2745;

import java.io.*;

public class b_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");

        char[] strArr = conds[0].toCharArray();
        int N = Integer.parseInt(conds[1]);

        long ret = 0;
        int n = 0;
        for (int i = strArr.length - 1; i >= 0; --i) {
            if (strArr[i] >= '0' && strArr[i] <= '9') {
                ret += (long)(Math.pow(N, n) * (strArr[i] - '0'));
            }
            if (strArr[i] >= 'A' && strArr[i] <= 'Z') {
                ret += (long)(Math.pow(N, n) * (strArr[i] - 'A' + 10));
            }
            ++n;
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
}
