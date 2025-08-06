package b_2696;


import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            test(br, bw);
            bw.newLine();
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static void test(BufferedReader br, BufferedWriter bw) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int dpIdx = 0;
        int lineLen = (N % 10 == 0) ? (N / 10) : (N / 10) + 1;
        for (int n = 0; n < lineLen; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                dp[dpIdx++] = Integer.parseInt(st.nextToken());
            }
        }

        int oddsNumber = (N / 2) + 1;
        int midIdx = 1;
        bw.write(String.valueOf(oddsNumber));
        bw.newLine();
        for (int i = 1; i <= N; ++i) {
            if (i % 2 != 0) {
                ++oddsNumber;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int j = 0; j < i; ++j) {
                    pq.add(dp[j]);
                }
                int pqSize = pq.size();
                int midNumber = -1;
                for (int j = 0; j <= (pqSize / 2); ++j) {
                    midNumber = pq.poll();
                }
                bw.write(String.valueOf(midNumber));
                if (midIdx % 10 == 0) {
                    bw.newLine();
                } else {
                    bw.write(" ");
                }
                ++midIdx;
            }
        }
    }
}
