package b_14391;

import java.io.*;

// 한번 비트맵 만들어서 시도해보기
public class b_14391_2 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] bitMap;
    private static int ret = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        dfs(0);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        map = new int[N][M];
        bitMap = new int[N][M];
        for (int y = 0; y < N; ++y) {
            String row = br.readLine();
            for (int x = 0; x < row.length(); ++x) {
                map[y][x] = (int)(row.charAt(x) - '0');
            }
        }
    }
    private static void dfs(int depth) {
        if (depth == N) {
            int sum = getSum();
            ret = Math.max(sum, ret);
            return;
        }
        for (int bitNum = 0; bitNum < (1 << M); ++bitNum) {
            for (int bit = 0; bit < M; ++bit) {
                if ((bitNum & (1 << bit)) != 0) {
                    bitMap[depth][bit] = 1;
                } else {
                    bitMap[depth][bit] = 0;
                }
            }
            dfs(depth + 1);
        }
    }

    private static int getSum() {
        int sum = 0;
        for (int y = 0; y < N; ++y) {
            int number = 0;
            for (int x = 0; x < M; ++x) {
                if (bitMap[y][x] == 0) {
                    number = (10 * number) + map[y][x];
                } else {
                    sum += number;
                    number = 0;
                }
            }
            sum += number;
        }
        for (int x = 0; x < M; ++x) {
            int number = 0;
            for (int y = 0; y < N; ++y) {
                if (bitMap[y][x] == 1) {
                    number = (10 * number) + map[y][x];
                } else {
                    sum += number;
                    number = 0;
                }
            }
            sum += number;
        }
        return sum;
    }
}
