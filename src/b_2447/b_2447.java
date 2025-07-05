package b_2447;

import java.io.*;
import java.util.Arrays;

public class b_2447 {
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(map[i], ' ');
        }
        dfs(0, 0, N);
        printMap(N, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x, int size) {
        if (size == 1) {
            map[y][x] = '*';
            return;
        }
        int interval = size / 3;
        // 1행
        dfs(y, x, interval);
        dfs(y, x + interval, interval);
        dfs(y, x + (2 * interval), interval);
        // 2행
        dfs(y + interval, x, interval);
        dfs(y + interval, x + (2 * interval), interval);
        // 3행
        dfs(y + (2 * interval), x, interval);
        dfs(y + (2 * interval), x + interval, interval);
        dfs(y + (2 * interval), x + (2 * interval), interval);
    }


    private static void printMap(int N, BufferedWriter bw) throws IOException {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                bw.write(String.valueOf(map[i][j]));
            }
            bw.newLine();
        }
    }
}
