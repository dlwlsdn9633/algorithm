package b_11054;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_11054 {
    private static int[] arr;
    private static int[] ascendingDp;
    private static int[] descendingDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ascendingDp = new int[N];
        descendingDp = new int[N];
        Arrays.fill(ascendingDp, 1);
        Arrays.fill(descendingDp, 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (arr[i] > arr[j]) {
                    ascendingDp[i] = Math.max(ascendingDp[i], ascendingDp[j] + 1);
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    descendingDp[i] = Math.max(descendingDp[i], descendingDp[j] + 1);
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            maxValue = Math.max(maxValue, ascendingDp[i] + descendingDp[i] - 1);
        }
        bw.write(String.valueOf(maxValue));

        bw.flush();
        bw.close();
        br.close();
    }
}
