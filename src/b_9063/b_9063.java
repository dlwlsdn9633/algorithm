package b_9063;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_9063 {
    private static int N;
    private static int[] xSet;
    private static int[] ySet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        xSet = new int[N];
        ySet = new int[N];
        for (int n = 0; n < N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xSet[n] = Integer.parseInt(st.nextToken());
            ySet[n] = Integer.parseInt(st.nextToken());
        }

        int diffX = Math.abs(getMax(xSet) - getMin(xSet));
        int diffY = Math.abs(getMax(ySet) - getMin(ySet));
        int ret = diffX * diffY;

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static int getMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
    private static int getMin(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }
}
