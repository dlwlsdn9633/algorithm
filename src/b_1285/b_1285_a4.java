package b_1285;

import java.io.*;

public class b_1285_a4 {
    private static int N;
    private static int map[];
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        dfs(0);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void dfs(int row) {
        if (row >= N) {
            int sumMinTNumber = 0;
            for (int colBit = 1; colBit <= (1 << N - 1); colBit *= 2) {
                int TNumber = 0;
                for (int rowIdx = 0; rowIdx < N; ++rowIdx) {
                    if ((map[rowIdx] & colBit) != 0) {
                        ++TNumber;
                    }
                }
                int minTNumber = Math.min(TNumber, N - TNumber);
                sumMinTNumber += minTNumber;
            }
            ret = Math.min(sumMinTNumber, ret);
            return;
        }
        dfs(row + 1);
        map[row] = ~map[row];
        dfs(row + 1);
    }
    private static void setMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        for (int i = 0; i < N; ++i) {
            int value = 1;
            String rowCoins = br.readLine();
            for (char coin : rowCoins.toCharArray()) {
                if (coin == 'T') {
                    map[i] |= value;
                }
                value *= 2;
            }
        }
    }
}
