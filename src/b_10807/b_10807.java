package b_10807;

import java.io.*;

public class b_10807 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] conds = br.readLine().split(" ");
        for (int n = 0; n < N; ++n) {
            arr[n] = Integer.parseInt(conds[n]);
        }
        int ret = 0;
        int findNumber = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            if (findNumber == arr[n]) {
                ++ret;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
