package b_2675;

import java.io.*;

public class b_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String[] conds = br.readLine().split(" ");
            int M = Integer.parseInt(conds[0]);
            String str = conds[1];
            for (char c : str.toCharArray()) {
                for (int m = 0; m < M; ++m) {
                    bw.write(c);
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
