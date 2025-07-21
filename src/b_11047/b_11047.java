package b_11047;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_11047 {
    private static int N;
    private static int K;
    private static int cnt;
    private static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        for (int coinIdx = N - 1; coinIdx >= 0; --coinIdx) {
            int currentCoin = coins[coinIdx];
            while (K >= currentCoin) {
                K -= currentCoin;
                ++cnt;
            }
        }
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        for (int idx = 0; idx < N; ++idx) {
            coins[idx] = Integer.parseInt(br.readLine());
        }
    }
}
