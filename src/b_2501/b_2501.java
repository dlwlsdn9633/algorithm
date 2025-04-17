package b_2501;

import java.io.*;

public class b_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        int number = Integer.parseInt(conds[0]);
        int finalIdx = Integer.parseInt(conds[1]);
        int idx = 1;
        int ret = 0;
        for (int n = 1; n <= number; ++n) {
            if (number % n == 0) {
                if (idx == finalIdx) {
                    ret = n;
                    break;
                }
                ++idx;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
