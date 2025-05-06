package b_1285;

import java.io.*;

public class b_1285_a6 {
    private static int N;
    private static int[] map = new int[21];
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        dfs(0);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int row) {
        if (row == N) {
            int totalTNumber = 0;
            for (int colBit = 1; colBit <= (1 << (N - 1)); colBit *= 2) {
                int TNumber = 0;
                for (int rowIdx = 0; rowIdx < N; ++rowIdx) {
                    if ((map[rowIdx] & colBit) != 0) {
                        ++TNumber;
                    }
                }
                int tNumberPerRow = Math.min(TNumber, N - TNumber);
                totalTNumber += tNumberPerRow;
            }
            ret = Math.min(totalTNumber, ret);
            return;
        }
        dfs(row + 1);
        map[row] = ~map[row];
        dfs(row + 1);
    }


    private static void setConds(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            int value = 1;
            String rows = br.readLine();
            for (char c : rows.toCharArray()) {
                if (c == 'T') {
                    map[n] |= value;
                }
                value *= 2;
            }
        }
    }
}
