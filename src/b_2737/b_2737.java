package b_2737;

import java.io.*;

public class b_2737 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            long total = Long.parseLong(br.readLine());

            System.out.println(test(total));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static long test(long total) {
        long ret = 0;
        long start = 1;
        long end = 1;
        while (start <= end && end < total) {
            long sum = 0L;
            for (long num = start; num <= end; ++num) {
                sum += num;
            }
            if (sum <= total) {
                if (sum == total) {
                    ++ret;
                }
                ++end;
            } else {
                ++start;
            }
        }
        return ret;
    }
}
