package b_1285;

import java.io.*;

public class b_1285_a3 {
    private static int N;
    private static int[] map; // 각 원소는 각 행에 관련된 수가 존재한다.
    private static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        setMap(br);

        bw.flush();
        bw.close();
    }
    private static void dfs(int row) {
        if (row == N + 1) {
            int sum = 0;
            for (int colBit = 1; colBit <= (1 << (N - 1)); colBit *= 2) {
                int ret = 0;
                for (int rowIdx = 1; rowIdx <= N; ++rowIdx) {
                    if ((map[rowIdx] & colBit) != 0) {
                        ++ret;
                    }
                }
                sum += Math.min(ret, N - ret);
            }
            minValue = Math.min(minValue, sum);
            return;
        }
        dfs(row + 1);
        map[row] = ~map[row];
        dfs(row + 1);
    }
    private static void setMap(BufferedReader br) throws IOException {
        for (int rowIdx = 1; rowIdx <= N; ++rowIdx) {
            String row = br.readLine();
            int value = 1;
            for (int j = 0; j < row.length(); ++j) {
                if (row.charAt(j) == 'T') {
                    map[rowIdx] |= value;
                }
                value *= 2;
            }
        }
    }

}
