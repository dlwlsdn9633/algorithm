package b_1912;

import java.io.*;

public class b_1912_a {
    private static int ret = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(conds[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            ret = Math.max(ret, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
