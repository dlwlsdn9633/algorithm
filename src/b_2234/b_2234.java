package b_2234;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b_2234 {
    private static int N;
    private static int M;
    private static int map[][];
    private static boolean visited[][];
    private static CostAttr[][] costMap;
    private static int[][] dirs = {
            { +0, -1 },
            { -1, +0 },
            { +0, +1 },
            { +1, +0 }
    };
    private static int maxRoomSize = Integer.MIN_VALUE;
    private static int roomsNumber = 0;
    private static int thirdAnswer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        setCostMap();
        setThirdAnswer();

        bw.write(String.valueOf(roomsNumber));
        bw.write("\n");
        bw.write(String.valueOf(maxRoomSize));
        bw.write("\n");
        bw.write(String.valueOf(thirdAnswer));

        bw.flush();
        bw.close();
    }
    private static void setThirdAnswer() {
        for (int y = 0; y < M; ++y) {
            for (int x = 0; x < N; ++x) {
                CostAttr currentCostAttr = costMap[y][x];
                for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                    int ny = y + dirs[dirIdx][0];
                    int nx = x + dirs[dirIdx][1];
                    if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                        continue;
                    }
                    if (currentCostAttr.roomNumber == costMap[ny][nx].roomNumber) {
                        continue;
                    }
                    int totalSize = currentCostAttr.roomSize + costMap[ny][nx].roomSize;
                    thirdAnswer = Math.max(thirdAnswer, totalSize);
                }
            }
        }
    }

    private static void bfs(int y, int x) {
        Queue<Pos> q = new LinkedList<>();
        Queue<Pos> positions = new LinkedList<>();

        boolean[][] visitedMap = new boolean[M][N];
        q.add(new Pos(y, x));
        visited[y][x] = true;
        visitedMap[y][x] = true;
        positions.add(new Pos(y, x));

        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();

            for (int i = 0; i < 4; ++i) {
                if ((map[currentPos.y][currentPos.x] & (1 << i)) != 0) {
                    continue;
                }
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;
                visitedMap[ny][nx] = true;
                q.add(new Pos(ny, nx));
                positions.add(new Pos(ny, nx));
            }
        }

        int maxValue = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (visitedMap[i][j]) {
                    ++maxValue;
                }
            }
        }

        maxRoomSize = Math.max(maxValue, maxRoomSize);
        while (positions.isEmpty() == false) {
            Pos currentPos = positions.poll();
            costMap[currentPos.y][currentPos.x] = new CostAttr(maxValue, roomsNumber);
        }
    }

    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        map = new int[M][N];
        visited = new boolean[M][N];
        costMap = new CostAttr[M][N];

        for (int m = 0; m < M; ++m) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < rows.length; ++j) {
                map[m][j] = Integer.parseInt(rows[j]);
            }
        }
    }
    private static void setCostMap() {
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(i, j);
                ++roomsNumber;
            }
        }
    }

    static class Pos {
        int y;
        int x;
        int cost;
        int roomNumber;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static class CostAttr {
        int roomSize;
        int roomNumber;
        public CostAttr(int roomSize, int roomNumber) {
            this.roomSize = roomSize;
            this.roomNumber = roomNumber;
        }
    }
}
