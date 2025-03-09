package b_14620;

import java.io.*;

public class b_14620 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int minValue = Integer.MAX_VALUE;
    private static int dirs[][] = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 },
            { +0, +0 }
    };
    private static int cost = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);

        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < N; ++x) {
                dfs(y, x, 0);
            }
        }

        System.out.println(minValue);
        bw.flush();
        bw.close();
    }

    private static void dfs(int selectY, int selectX, int depth) {
        if (depth == 3) {
            minValue = Math.min(cost, minValue);
            return;
        }

        // 검증하기
        for (int i = 0; i < 5; ++i) {
            int ny = selectY + dirs[i][0];
            int nx = selectX + dirs[i][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                return;
            }
            if (visited[ny][nx]) {
                return;
            }
        }

        insertFlowers(selectY, selectX);
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < N; ++x) {
                dfs(y, x, depth + 1);
            }
        }
        removeFlowers(selectY, selectX);
    }
    private static void insertFlowers(int selectY, int selectX) {
        // 꽃 심기
        for (int i = 0; i < 5; ++i) {
            int ny = selectY + dirs[i][0];
            int nx = selectX + dirs[i][1];
            visited[ny][nx] = true;
            cost += map[ny][nx];
        }
    }
    private static void removeFlowers(int selectY, int selectX) {
        // 꽃 뽑기
        for (int i = 0; i < 5; ++i) {
            int ny = selectY + dirs[i][0];
            int nx = selectX + dirs[i][1];
            visited[ny][nx] = false;
            cost -= map[ny][nx];
        }
    }
    private static void setMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int y = 0; y < N; ++y) {
            String[] rows = br.readLine().split(" ");
            for (int x = 0; x < rows.length; ++x) {
                map[y][x] = Integer.parseInt(rows[x]);
            }
        }
    }
}
