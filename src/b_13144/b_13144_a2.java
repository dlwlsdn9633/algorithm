package b_13144;

import java.io.*;
public class b_13144_a2 {
    private static int N;
    private static int[] arr = new int[100_001];
    private static boolean[] visited = new boolean[100_001];
    private static int startPointer;
    private static int endPointer;
    private static long ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            arr[i] = Integer.parseInt(conds[i]);
        }
        while (endPointer < N) {
            if (!visited[arr[endPointer]]) {
                visited[arr[endPointer]] = true;
                ++endPointer;
            } else {
                ret += (endPointer - startPointer);
                visited[arr[startPointer]] = false;
                ++startPointer;
            }
        }
        ret += ((long)(endPointer - startPointer) * (long)(endPointer - startPointer + 1) / 2);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
