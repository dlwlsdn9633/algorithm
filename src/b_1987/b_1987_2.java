package b_1987;

import java.io.*;

public class b_1987_2 {
    private static int ret = Integer.MIN_VALUE;
    private static int R;
    private static int C;
    private static char map[][];
    private static boolean[] visited = new boolean[26];
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
        map = new char[R][C];
        for (int r = 0; r < R; ++r) {
            String row = br.readLine();
            for (int c = 0; c < C; ++c) {
                map[r][c] = row.charAt(c);
            }
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
    private static void dfs(int y, int x, int depth) {
        if (isNoWayToGo(y, x)) {
            ret = Math.max(ret, depth);
            return;
        }
        for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
            int ny = y + dirs[dirIdx][0];
            int nx = x + dirs[dirIdx][1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                continue;
            }
            if (visited[map[ny][nx] - 'A']) {
                continue;
            }
            visited[map[ny][nx] - 'A'] = true;
            dfs(ny, nx, depth + 1);
            visited[map[ny][nx] - 'A'] = false;
        }
    }

    private static boolean isNoWayToGo(int y, int x) {
        for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
            int ny = y + dirs[dirIdx][0];
            int nx = x + dirs[dirIdx][1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                continue;
            }
            if (visited[map[ny][nx] - 'A']) {
                continue;
            }
            return false;
        }
        return true;
    }
}
