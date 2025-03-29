package b_2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b_2178_2_bfs {
    private static int N;
    private static int M;
    private static char[][] map;
    private static boolean[][] visited;
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
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; ++r) {
            map[r] = br.readLine().toCharArray();
        }

        int ret = Integer.MAX_VALUE;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 1));
        visited[0][0] = true;

        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();
            if (currentPos.y == N - 1 && currentPos.x == M - 1) {
                ret = currentPos.cost;
                break;
            }
            for (int i = 0; i < 4; ++i) {
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == '0') {
                    continue;
                }
                visited[ny][nx] = true;
                q.add(new Pos(ny, nx, currentPos.cost + 1));
            }
        }
        System.out.println(ret);
    }
    static class Pos {
        int y;
        int x;
        int cost;
        public Pos(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
