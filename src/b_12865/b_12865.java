package b_12865;

import java.io.*;
import java.util.StringTokenizer;

public class b_12865 {
    private static int N;
    private static int K;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        bw.flush();
        bw.close();
        br.close();
    }
}
