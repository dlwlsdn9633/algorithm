package b_15552;

import java.io.*;

public class b_1552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String[] conds = br.readLine().split(" ");
            int a = Integer.parseInt(conds[0]);
            int b = Integer.parseInt(conds[1]);

            bw.write(String.valueOf(a + b));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
