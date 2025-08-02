package lis_practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class on2 {
    private final static int[] arr = { 10, 20, 10, 30, 20, 50 };
    private static int[] dp;
    private static int[] tracing;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[arr.length];
        tracing = new int[arr.length];
        Arrays.fill(tracing, -1);

        int ret = Integer.MIN_VALUE;
        int startIdx = -1;
        for (int i = 0; i < arr.length; ++i) {
            int maxValue = 0;
            for (int j = 0; j < i; ++j) {
                if (arr[j] < arr[i] && maxValue < dp[j]) {
                    maxValue = dp[j];
                    tracing[i] = j;
                }
            }
            dp[i] = maxValue + 1;
            if (ret < dp[i]) {
                ret = dp[i];
                startIdx = i;
            }
        }
        bw.write(String.valueOf(ret));
        bw.newLine();

        List<Integer> traceList = new ArrayList<>();
        while (startIdx != -1) {
            traceList.add(arr[startIdx]);
            startIdx = tracing[startIdx];
        }
        List<Integer> retList = traceList.reversed();
        for (int ele : retList) {
            bw.write(ele + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
