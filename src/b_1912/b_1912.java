package b_1912;

import java.io.*;
public class b_1912 {
    private static int ret = Integer.MIN_VALUE;
    private static int n;
    private static int[] arr;
    private static int[] sumArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2];
        sumArr = new int[n + 2];
        String[] conds = br.readLine().split(" ");
        for (int i = 1; i <= conds.length; ++i) {
            arr[i + 1] = Integer.parseInt(conds[i - 1]);
            sumArr[i] = sumArr[i - 1] + arr[i + 1];
        }

        for (int interval = 1; interval <= n; ++interval) {
            for (int start = interval; start <= n; ++start) {
                int sum = sumArr[start] - sumArr[start - interval];
                ret = Math.max(sum, ret);
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
