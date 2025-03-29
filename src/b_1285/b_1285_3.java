package b_1285;

import java.io.*;

public class b_1285_3 {
    private static int N;
    private static int[] map;
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        dfs(1);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    // 뒤집으면서 최소한의 T를 가지는 Map을 찾기
    private static void dfs(int row) {
        if (row == N + 1) {
            int totalTailsNum = 0;
            for (int colBit = 1; colBit <= (1 << (N - 1)); colBit *= 2) {
                int tailsNum = 0;
                for (int rowIdx = 1; rowIdx <= N; ++rowIdx) {
                    if ((map[rowIdx] & colBit) != 0) {
                        ++tailsNum;
                    }
                }
                totalTailsNum += Math.min(tailsNum, N - tailsNum);
            }
            ret = Math.min(ret, totalTailsNum);
            return;
        }

        dfs(row + 1);
        map[row] = ~map[row];
        dfs(row + 1);
    }

    // 맵을 세팅 완료했고
    private static void setMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1];
        for (int rowIdx = 1; rowIdx <= N; ++rowIdx) {
            // 점심시간 이후에 작성
            int value = 1;
            String row = br.readLine();
            for (char c : row.toCharArray()) {
                if (c == 'T') {
                    map[rowIdx] |= value;
                }
                value *= 2;
            }
        }
    }
}
