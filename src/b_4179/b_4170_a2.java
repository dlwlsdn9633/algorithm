package b_4179;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_4170_a2 {
    private static int R;
    private static int C;
    private static int fireMap[][];
    private static int personMap[][];
    private static char map[][];
    private static Queue<Pos> personQueue = new LinkedList<>();
    private static Queue<Pos> fireQueue = new LinkedList<>();
    private static int dirs[][] = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    private static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");

        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);

        setMap(br);
        setFireMap();
        personMove();

        if (ret == 0) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write(String.valueOf(ret));
        }
        bw.flush();
        bw.close();
    }
    private static void personMove() {
        while (personQueue.isEmpty() == false) {
            Pos currentPos = personQueue.poll();
            if (currentPos.y == 0 || currentPos.y == R - 1 || currentPos.x == 0 || currentPos.x == C - 1) {
                ret = personMap[currentPos.y][currentPos.x];
                break;
            }
            for (int i = 0; i < 4; ++i) {
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (personMap[ny][nx] != 0) {
                    continue; // 이미 방문한 곳인지 체크
                }
                if (map[ny][nx] == '#') {
                    continue;
                }
                if (personMap[currentPos.y][currentPos.x] + 1 >= fireMap[ny][nx]) {
                    continue;
                }
                personMap[ny][nx] = personMap[currentPos.y][currentPos.x] + 1;
                personQueue.add(new Pos(ny, nx));
            }
        }
    }
    private static void setFireMap() {
        while (fireQueue.isEmpty() == false) {
            Pos currentPos = fireQueue.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (fireMap[ny][nx] != Integer.MAX_VALUE) {
                    // 여기가 다르네
                    continue;
                }
                if (map[ny][nx] == '#') {
                    continue;
                }
                fireMap[ny][nx] = fireMap[currentPos.y][currentPos.x] + 1;
                fireQueue.add(new Pos(ny, nx));
            }
        }
    }

    private static void setMap(BufferedReader br) throws IOException {
        map = new char[R][C];
        fireMap = new int[R][C];
        personMap = new int[R][C];
        for (int r = 0; r < R; ++r) {
            Arrays.fill(fireMap[r], Integer.MAX_VALUE);
            // 여기서 다르네
            Arrays.fill(personMap[r], 0);
        }
        for (int y = 0; y < R; ++y) {
            String row = br.readLine();
            for (int x = 0; x < C; ++x) {
                map[y][x] = row.charAt(x);
                if (map[y][x] == 'F') {
                    fireQueue.add(new Pos(y, x));
                    fireMap[y][x] = 1;
                }
                if (map[y][x] == 'J') {
                    personQueue.add(new Pos(y, x));
                    personMap[y][x] = 1;
                }
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
