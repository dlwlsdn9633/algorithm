package b_10950;

import java.io.*;

public class b_10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            String[] conds = br.readLine().split(" ");
            int ret = Integer.parseInt(conds[0]) + Integer.parseInt(conds[1]);
            bw.write(String.valueOf(ret));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
