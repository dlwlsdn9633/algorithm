package b_17144;

import java.io.*;
import java.util.*;

public class b_17144 {
    private static int R;
    private static int C;
    private static int T;
    private static int[][] map;
    private static int[][] dustMap;
    private static List<Pos> cleanerPos = new ArrayList<>();
    private static int[][] dirs = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);

        for (int t = 0; t < T; ++t) {
            spread();
            clean();
        }
        //printMap();
        int sum = getSum();
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }

    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dustMap = new int[R][C];
        for (int r = 0; r < R; ++r) {
            String[] row = br.readLine().split(" ");
            for (int c = 0; c < C; ++c) {
                map[r][c] = Integer.parseInt(row[c]);
                if (map[r][c] == -1) {
                    cleanerPos.add(new Pos(r, c));
                }
            }
        }
    }
    private static void spread() {
        Queue<Pos> q = new LinkedList<>();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (map[r][c] > 0) {
                    q.add(new Pos(r, c, map[r][c]));
                }
            }
        }
        while (!q.isEmpty()) {
            Pos currentPos = q.poll();
            Queue<Pos> nextPosQ = new LinkedList<>();
            for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                int nextY = currentPos.y + dirs[dirIdx][0];
                int nextX = currentPos.x + dirs[dirIdx][1];
                if (nextY < 0 || nextX < 0 || nextY >= R || nextX >= C) {
                    continue;
                }
                if (map[nextY][nextX] == -1) {
                    continue;
                }
                nextPosQ.add(new Pos(nextY, nextX));
            }
            int spreadDust = currentPos.value / 5;
            int centerDust = currentPos.value - (spreadDust * nextPosQ.size());
            dustMap[currentPos.y][currentPos.x] += centerDust;
            while (!nextPosQ.isEmpty()) {
                Pos nextPos = nextPosQ.poll();
                dustMap[nextPos.y][nextPos.x] += spreadDust;
            }
        }
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (map[r][c] != -1) {
                    map[r][c] = dustMap[r][c];
                    dustMap[r][c] = 0;
                }
            }
        }
    }
    private static void clean() {
        // up
        for (int r = cleanerPos.get(0).y - 1; r >= 0; --r) {
            int nextPos = r + 1;
            if (map[nextPos][0] == -1) {
                map[r][0] = 0;
            } else {
                map[nextPos][0] = map[r][0];
            }
        }
        for (int c = 1; c < C; ++c) {
            int nextPos = c - 1;
            map[0][nextPos] = map[0][c];
        }
        for (int r = 1; r <= cleanerPos.get(0).y; ++r) {
            int nextPos = r - 1;
            map[nextPos][C - 1] = map[r][C - 1];
        }
        for (int c = C - 2; c >= 1; --c) {
            int nextPos = c + 1;
            map[cleanerPos.get(0).y][nextPos] = map[cleanerPos.get(0).y][c];
        }
        map[cleanerPos.get(0).y][cleanerPos.get(0).x + 1] = 0;
        // down
        for (int r = cleanerPos.get(1).y + 1; r < R; ++r) {
            int nextPos = r - 1;
            if (map[nextPos][0] == -1) {
                map[r][0] = 0;
            } else {
                map[nextPos][0] = map[r][0];
            }
        }
        for (int c = 1; c < C; ++c) {
            int nextPos = c - 1;
            map[R - 1][nextPos] = map[R - 1][c];
        }
        for (int r = R - 2; r >= cleanerPos.get(1).y; --r) {
            int nextPos = r + 1;
            map[nextPos][C - 1] = map[r][C - 1];
        }
        for (int c = C - 2; c >= 1; --c) {
            int nextPos = c + 1;
            map[cleanerPos.get(1).y][nextPos] = map[cleanerPos.get(1).y][c];
        }
        map[cleanerPos.get(1).y][cleanerPos.get(1).x + 1] = 0;
    }
    private static int getSum() {
        int sum = 0;
        for (int y = 0; y < R; ++y) {
            for (int x = 0; x < C; ++x) {
                if (map[y][x] == -1) {
                    continue;
                }
                sum += map[y][x];
            }
        }
        return sum;
    }

    private static void printMap() {
        for (int y = 0; y < R; ++y) {
            for (int x = 0; x < C; ++x) {
                System.out.print(map[y][x] + "\t");
            }
            System.out.println();
        }
    }

    static class Pos {
        int y;
        int x;
        int value;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public Pos(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
}
