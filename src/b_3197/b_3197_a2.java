package b_3197;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b_3197_a2 {
    private static int R;
    private static int C;
    private static char[][] map;
    private static boolean[][] visitSwan;
    private static boolean[][] visitWater;
    private static Queue<Pos> waterQ = new LinkedList<>();
    private static Queue<Pos> swanQ = new LinkedList<>();
    private static Queue<Pos> swanNextStartQ = new LinkedList<>(); // 약간 이게 Cache 역할을 해주고 있네..?
    private static Queue<Pos> waterNextStartQ = new LinkedList<>();
    private static int[][] dirs = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        setMap(br);
        int day = 0;
        while (true) {
            if (meetSwan()) {
                break;
            }
            meltIce();
            deepCopy();
            ++day;
        }
        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }
    private static void deepCopy() {
        while (swanNextStartQ.isEmpty() == false) {
            swanQ.add(swanNextStartQ.poll());
        }
        while (waterNextStartQ.isEmpty() == false) {
            waterQ.add(waterNextStartQ.poll());
        }
    }
    private static void meltIce() {
        while (waterQ.isEmpty() == false) {
            Pos currentWaterPos = waterQ.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = currentWaterPos.y + dirs[i][0];
                int nx = currentWaterPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (visitWater[ny][nx]) {
                    continue;
                }
                visitWater[ny][nx] = true;
                if (map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    waterNextStartQ.add(new Pos(ny, nx));
                } else {
                    waterQ.add(new Pos(ny, nx));
                }
            }
        }
    }
    private static boolean meetSwan() {
        while (swanQ.isEmpty() == false) {
            Pos currentSwanPos = swanQ.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = currentSwanPos.y + dirs[i][0];
                int nx = currentSwanPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (visitSwan[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 'L') {
                    return true;
                }
                visitSwan[ny][nx] = true;
                if (map[ny][nx] == 'X') {
                    swanNextStartQ.add(new Pos(ny, nx));
                } else {
                    swanQ.add(new Pos(ny, nx));
                }
            }
        }
        return false;
    }

    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        map = new char[R][C];
        visitSwan = new boolean[R][C];
        visitWater = new boolean[R][C];

        int swanY = 0;
        int swanX = 0;
        for (int r = 0; r < R; ++r) {
            String row = br.readLine();
            for (int c = 0; c < row.length(); ++c) {
                map[r][c] = row.charAt(c);
                if (map[r][c] == '.' || map[r][c] == 'L') {
                    visitWater[r][c] = true;
                    waterQ.add(new Pos(r, c));
                }
                if (map[r][c] == 'L') {
                    // 왜 한 마리 백조만 저장하는걸까? -> 두 마리 백조가 모두 움직이게 된다면, 영원히 만날 수 없기 때문에 (why? visitSwan 배열이 모두 true이므로 움직일 수 없게 됨)
                    swanY = r;
                    swanX = c;
                }
            }
        }
        swanQ.add(new Pos(swanY, swanX));
        visitSwan[swanY][swanX] = true;
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
