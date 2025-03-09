package b_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_1987 {
    private static int R;
    private static int C;
    private static char[][] map;
    private static boolean[] visited;
    private static int maxValue = 0;
    private static int dirs[][] = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        map = new char[R][C];
        for (int r = 0; r < R; ++r) {
            String row = br.readLine();
            map[r] = row.toCharArray();
        }
        visited = new boolean[26];
        Arrays.fill(visited, false);
        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(maxValue);
    }
    private static void dfs(int y, int x, int cost) {
        maxValue = (maxValue < cost) ? cost : maxValue;
        for (int i = 0; i < 4; ++i) {
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                continue;
            }
            if (visited[map[ny][nx] - 'A'] == true) {
                continue;
            }
            visited[map[ny][nx] - 'A'] = true;
            dfs(ny, nx, cost + 1);
            visited[map[ny][nx] - 'A'] = false;
        }
    }
}
