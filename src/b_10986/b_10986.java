package b_10986;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_10986 {
    private static int N;
    private static int M;
    private static int[] dp;
    private static int[] arr;
    private static int[] SArr;
    private static int[] MArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        for (int i = 0; i < N; ++i) {
            ++dp[MArr[i]];
        }
        long sum = 0L;
        for (int num = 0; num < M; ++num) {
            if (dp[num] != 0) {
                sum += getComb(dp[num]);
            }
        }
        sum += dp[0];
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M];
        arr = new int[N];
        SArr = new int[N];
        MArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        SArr[0] = arr[0];
        MArr[0] = arr[0];



        for (int i = 1; i < N; ++i) {
            SArr[i] = SArr[i - 1] + arr[i];
        }
        for (int i = 0; i < N; ++i) {
            MArr[i] = SArr[i] % M;
        }
    }
    private static long getComb(int number) {
        return ((long)(number) * (long)(number - 1)) / 2L;
    }
}
