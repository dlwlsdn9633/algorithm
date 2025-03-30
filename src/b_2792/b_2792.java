package b_2792;

import java.io.*;

public class b_2792 {
    private static long[] diamonds;
    private static long N;
    private static int M;
    private static long minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Long.parseLong(conds[0]);
        M = Integer.parseInt(conds[1]);

        diamonds = new long[M];
        long maxDiamondsNum = Integer.MIN_VALUE;
        for (int m = 0; m < M; ++m) {
            diamonds[m] = Integer.parseInt(br.readLine());
            maxDiamondsNum = Math.max(maxDiamondsNum, diamonds[m]);
        }

        long leftPointer = 1;
        long rightPointer = maxDiamondsNum;
        while (leftPointer <= rightPointer) {
            long mid = (leftPointer + rightPointer) / 2;
            if (search(mid)) {
                minValue = Math.min(minValue, mid);
                rightPointer = mid - 1;
            } else {
                leftPointer = mid + 1;
            }
        }

        bw.write(String.valueOf(minValue));
        bw.flush();
        bw.close();
    }

    private static boolean search(long mid) {
        long ret = 0;
        for (int i = 0; i < diamonds.length; ++i) {
            ret += (diamonds[i] / mid);
            if ((diamonds[i] % mid) != 0) {
                ++ret;
            }
        }
        return ret <= N;
    }
}
