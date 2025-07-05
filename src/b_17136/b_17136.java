package b_17136;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b_17136 {
    private static int ret = Integer.MAX_VALUE;
    private static final int MAX_LEN = 10;
    private static final int MAX_SIZE = 5;
    private static final int[][] map = new int[MAX_LEN][MAX_LEN];
    private static final boolean[][] visited = new boolean[MAX_LEN][MAX_LEN];
    private static final List<Pos> posList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        dfs(0, 0);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void setMap(BufferedReader br) throws IOException {
        for (int i = 0; i < MAX_LEN; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX_LEN; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    posList.add(new Pos(i, j));
                }
            }
        }
    }
    private static void dfs(int depth, int use) {
        if (depth >= posList.size()) {
            if (isAllTrue()) {
                ret = Math.min(ret, use);
            }
            return;
        }
        Pos currentPos = posList.get(depth);
        for (int len = 0; len < MAX_SIZE; ++len) {
            if (isOutside(currentPos.y, currentPos.x, len)) {
                continue;
            }
            if (isAllOne(currentPos.y, currentPos.x, len)) {
                if (visited[currentPos.y][currentPos.x]) {
                    dfs(depth + 1, use);
                } else {
                    fillVisited(currentPos.y, currentPos.x, len, true);
                    dfs(depth + 1, use + 1);
                    fillVisited(currentPos.y, currentPos.x, len, false);
                }
            } else {
                dfs(depth + 1, use);
            }
        }
    }
    private static boolean isAllTrue() {
        for (Pos pos : posList) {
            if (!visited[pos.y][pos.x]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOutside(int y, int x, int len) {
        return y + len >= MAX_LEN || x + len >= MAX_LEN;
    }
    private static boolean isAllOne(int y, int x, int len) {
        for (int i = y; i <= y + len; ++i) {
            for (int j = x; j <= x + len; ++j) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void fillVisited(int y, int x, int len, boolean v) {
        for (int i = y; i <= y + len; ++i) {
            for (int j = x; j <= x + len; ++j) {
                visited[i][j] = v;
            }
        }
    }
    static class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
