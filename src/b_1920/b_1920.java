package b_1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1920 {
    private static int N;
    private static int[] candidates;
    private static int M;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; ++n) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        candidates = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; ++m) {
            candidates[m] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int m = 0; m < M; ++m) {
            int idx = binarySearch(0, arr.length - 1, candidates[m]);
            if (idx == -1) {
                bw.write(String.valueOf(0));
            } else {
                bw.write(String.valueOf(1));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int left, int right, int value) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
