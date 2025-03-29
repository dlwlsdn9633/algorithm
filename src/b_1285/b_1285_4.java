package b_1285;

import java.io.*;

public class b_1285_4 {
    private static int N;
    private static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1];
        for (int rowIdx = 0; rowIdx < N; ++rowIdx) {
            String row = br.readLine();
            int value = 1;
            for (char c : row.toCharArray()) {
                if (c == 'T') {
                    map[rowIdx] |= value;
                }
                value *= 2;
            }
        }


        bw.flush();
        bw.close();
    }

    private static void dfs(int row) {
        if (row == N + 1) {
            int totalTails = 0;
            for (int colBit = 1; colBit <= (1 << (N - 1)); ++colBit) {
                int totalTail = 0;
                for (int rowIdx = 1; rowIdx <= N; ++rowIdx) {
                    if ((map[rowIdx] & colBit) != 0) {

                    }
                }
            }
        }
        dfs(row + 1);
        map[row] = ~map[row];
        dfs(row + 1);
    }


}
