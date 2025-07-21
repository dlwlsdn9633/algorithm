package b_11399;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_11399 {

    private static int[] dp;
    private static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, dp.length - 1);
        S[0] = dp[0];
        for (int i = 1; i < S.length; ++i) {
            S[i] = S[i - 1] + dp[i];
        }
        int sum = Arrays.stream(S).sum();
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void merge(int left, int mid, int right) {
        int leftPointer = left;
        int rightPointer = mid + 1;

        int tmpPointer = 0;
        int[] tmp = new int[right - left + 1];

        while (leftPointer <= mid && rightPointer <= right) {
            if (dp[leftPointer] <= dp[rightPointer]) {
                tmp[tmpPointer++] = dp[leftPointer++];
            } else {
                tmp[tmpPointer++] = dp[rightPointer++];
            }
        }


        while (leftPointer <= mid) {
            tmp[tmpPointer++] = dp[leftPointer++];
        }
        while (rightPointer <= right) {
            tmp[tmpPointer++] = dp[rightPointer++];
        }
        System.arraycopy(tmp, 0, dp, left, tmp.length);
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

}
