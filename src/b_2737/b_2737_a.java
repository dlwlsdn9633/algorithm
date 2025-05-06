package b_2737;

import java.io.*;

public class b_2737_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            long N = Long.parseLong(br.readLine());
            long ret = go(N);
            bw.write(String.valueOf(ret));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static long go(long N) {
        long k = 2;
        long ret = 0;
        while (k * (k - 1) < 2 * N) {
            if(isExistedSequenceSum(k, N)) {
                ++ret;
            }
            ++k;
        }
        return ret;
    }
    private static boolean isExistedSequenceSum(long k, long N) {
        long ret = (N - ((k * (k - 1)) / 2)) % k;
        return ret == 0L;
    }

}
