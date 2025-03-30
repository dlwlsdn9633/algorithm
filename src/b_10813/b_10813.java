package b_10813;

import java.io.*;

public class b_10813 {
    private static int[] baskets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int N = Integer.parseInt(conds[0]);
        int M = Integer.parseInt(conds[1]);
        baskets = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            baskets[i] = i;
        }
        for (int m = 0; m < M; ++m) {
            String[] balls = br.readLine().split(" ");
            int from = Integer.parseInt(balls[0]);
            int to = Integer.parseInt(balls[1]);

            int temp = baskets[from];
            baskets[from] = baskets[to];
            baskets[to] = temp;
        }

        for (int i = 1; i <= N; ++i) {
            bw.write(baskets[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
