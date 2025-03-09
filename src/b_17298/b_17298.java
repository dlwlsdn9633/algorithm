package b_17298;

import java.io.*;

public class b_17298 {
    private static int dp[];
    private static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        dp = new int[N];
        arr = new int[N];

        String[] arrList = bf.readLine().split(" ");
        for (int i = 0; i < arrList.length; ++i) {
            arr[i] = Integer.parseInt(arrList[i]);
        }

        for (int i = 0; i < N; ++i) {
            dp[i] = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (dp[j] == -1 && arr[j] < arr[i]) {
                    dp[j] = arr[i];
                }
            }
        }

        for (int ele : dp) {
            bw.write(ele + " ");
        }

        bw.flush();
        bw.close();
    }
}
