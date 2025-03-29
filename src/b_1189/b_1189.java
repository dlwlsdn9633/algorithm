package b_1189;

import java.io.*;
import java.util.Arrays;

public class b_1189 {
    private static int R;
    private static int C;
    private static int K;
    private static char[][] map;
    private static boolean[][] visited;
    private static int ret = 0;
    private static int[][] dirs = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        K = Integer.parseInt(conds[2]);

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; ++r) {
            Arrays.fill(visited[r], false);
        }
        for (int r = 0; r < R; ++r) {
            map[r] = br.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(ret);
        bw.flush();
        bw.close();
    }
    private static void dfs(int y, int x, int depth) {
        if (y == 0 && x == C - 1) {
            if (depth == K) {
                ++ret;
            }
            return;
        }
        for (int i = 0; i < 4; ++i) {
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (map[ny][nx] == 'T') {
                continue;
            }
            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1);
            visited[ny][nx] = false;
        }
    }

    private static void printMap() {
        System.out.println();
        for (int y = 0; y < R; ++y) {
            for (int x = 0; x < C; ++x) {
                System.out.print(visited[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}


