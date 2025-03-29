package b_2234;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b_2234_2 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] dirs = {
            { +0, -1 },
            { -1, +0 },
            { +0, +1 },
            { +1, +0 }
    };
    private static boolean[][] visit;
    private static int roomNumber = 0;
    private static int currentArea = 0;
    private static int maxArea = Integer.MIN_VALUE;
    private static int[][] areaMap;
    private static int[][] mapColorMap;
    private static int mapColor = 1;
    private static Queue<Pos> q = new LinkedList<>();
    private static int areaWithoutWall = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);

        for (int y = 0; y < M; ++y) {
            for (int x = 0; x < N; ++x) {
                if (visit[y][x] == false) {
                    visit[y][x] = true;
                    mapColorMap[y][x] = mapColor;
                    currentArea = 1;
                    q.add(new Pos(y, x));
                    dfs(y, x);
                    while (q.isEmpty() == false) {
                        Pos currentPos = q.poll();
                        areaMap[currentPos.y][currentPos.x] = currentArea;
                        mapColorMap[currentPos.y][currentPos.x] = mapColor;
                    }
                    maxArea = Math.max(maxArea, currentArea);
                    ++roomNumber;
                    ++mapColor;
                }
            }
        }

        for (int y = 0; y < M; ++y) {
            for (int x = 0; x < N; ++x) {
                for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                    int ny = y + dirs[dirIdx][0];
                    int nx = x + dirs[dirIdx][1];
                    if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                        continue;
                    }
                    if (mapColorMap[ny][nx] == mapColorMap[y][x]) {
                        continue;
                    }
                    int sum = areaMap[ny][nx] + areaMap[y][x];
                    areaWithoutWall = Math.max(areaWithoutWall, sum);
                }
            }
        }


        bw.write(String.valueOf(roomNumber));
        bw.write("\n");
        bw.write(String.valueOf(maxArea));
        bw.write("\n");
        bw.write(String.valueOf(areaWithoutWall));

        bw.flush();
        bw.close();
    }

    private static void dfs(int y, int x) {
        for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
            int ny = y + dirs[dirIdx][0];
            int nx = x + dirs[dirIdx][1];
            if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                continue;
            }
            if (visit[ny][nx] == true) {
                continue;
            }
            if ((map[y][x] & (1 << dirIdx)) != 0) {
                continue;
            }
            visit[ny][nx] = true;
            ++currentArea;
            q.add(new Pos(ny, nx));
            dfs(ny, nx);
        }
    }

    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        map = new int[M][N];
        visit = new boolean[M][N];
        areaMap = new int[M][N];
        mapColorMap = new int[M][N];
        for (int y = 0; y < M; ++y) {
            String[] rows = br.readLine().split(" ");
            for (int x = 0; x < rows.length; ++x) {
                map[y][x] = Integer.parseInt(rows[x]);
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
    }
}
