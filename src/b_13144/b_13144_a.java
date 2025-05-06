package b_13144;

import java.io.*;

public class b_13144_a {
    private static long N;
    private static int[] arr = new int[100_001];
    private static int[] visit = new int[100_001];
    private static int startPoint;
    private static int endPoint;
    private static long ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine());
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            arr[i] = Integer.parseInt(conds[i]);
        }

        while (endPoint < N) {
            if (visit[arr[endPoint]] == 0) {
                visit[arr[endPoint]]++;
                ++endPoint;
            } else {
                ret += (endPoint - startPoint);
                visit[arr[startPoint]]--;
                ++startPoint;
            }
        }

        ret += (long)(endPoint - startPoint) * (long)(endPoint - startPoint + 1) / 2;
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
