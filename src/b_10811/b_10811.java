package b_10811;

import java.io.*;
public class b_10811 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int N = Integer.parseInt(conds[0]);
        int M = Integer.parseInt(conds[1]);
        arr = new int[N + 1];
        for (int i = 0; i < N + 1; ++i) {
            arr[i] = i;
        }

        for (int m = 0; m < M; ++m) {
            String[] rangeConds = br.readLine().split(" ");
            int startRange = Integer.parseInt(rangeConds[0]);
            int endRange = Integer.parseInt(rangeConds[1]);
            int totalNumber = (endRange - startRange + 1) / 2;
            for (int i = 0; i < totalNumber; ++i) {
                int start = startRange + i;
                int end = endRange - i;
                swap(start, end);
            }
        }

        for (int i = 1; i <= N; ++i) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
    private static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
