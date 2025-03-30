package b_10810;

import java.io.*;

public class b_10810 {
    private static int[] baskets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int N = Integer.parseInt(conds[0]);
        int M = Integer.parseInt(conds[1]);

        baskets = new int[N + 1];
        for (int m = 0; m < M; ++m) {
            String[] balls = br.readLine().split(" ");
            int startRange = Integer.parseInt(balls[0]);
            int endRange = Integer.parseInt(balls[1]);
            int ballNumber = Integer.parseInt(balls[2]);
            for (int r = startRange; r <= endRange; ++r) {
                baskets[r] = ballNumber;
            }
        }
        for (int i = 1; i <= N; ++i) {
            bw.write(baskets[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
