package b_10986;

import java.io.*;
import java.util.StringTokenizer;

public class b_10986_2 {
    private static int N;
    private static int M;
    private static long[] dp;
    private static long[] arr;
    private static long[] SArr;
    private static long[] MArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        for (int idx = 0; idx < N; ++idx) {
            ++dp[(int)MArr[idx]];
        }
        long sum = 0L;
        for (int num = 0; num < M; ++num) {
            if (dp[num] != 0) {
                sum += getComb(dp[num]);
            }
        }
        sum += (long)dp[0];
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[M];
        arr = new long[N];
        SArr = new long[N];
        MArr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; ++idx) {
            arr[idx] = Long.parseLong(st.nextToken());
        }
        SArr[0] = arr[0];
        for (int idx = 1; idx < N; ++idx) {
            SArr[idx] = SArr[idx - 1] + arr[idx];
        }
        for (int idx = 0; idx < N; ++idx) {
            MArr[idx] = SArr[idx] % M;
        }
    }
    private static long getComb(long number) {
        return ((long)(number) * (long)(number - 1)) / 2L;
    }
}
