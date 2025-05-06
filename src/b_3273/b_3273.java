package b_3273;

import java.io.*;
import java.util.Arrays;

public class b_3273 {
    private static int[] arr;
    private static int startPointer;
    private static int endPointer;
    private static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        endPointer = n - 1;
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            arr[i] = Integer.parseInt(conds[i]);
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        while (startPointer < endPointer) {
            if (arr[startPointer] + arr[endPointer] > x) {
                --endPointer;
            } else if (arr[startPointer] + arr[endPointer] < x) {
                ++startPointer;
            } else {
                ++ret;
                --endPointer;
            }
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
}
