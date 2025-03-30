package b_3197;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b_3197_2 {
    private static int R;
    private static int C;
    private static char[][] map;
    private static boolean[][] visitSwan;
    private static boolean[][] visitWater;
    private static Queue<Pos> swanQ = new LinkedList<>();
    private static Queue<Pos> reserSwanQ = new LinkedList<>();
    private static Queue<Pos> waterQ = new LinkedList<>();
    private static Queue<Pos> reserWaterQ = new LinkedList<>();
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
            meltWater();
            copyQ();
            ++day;
        }
        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }
    private static void copyQ() {
        while (reserWaterQ.isEmpty() == false) {
            waterQ.add(reserWaterQ.poll());
        }
        while (reserSwanQ.isEmpty() == false) {
            swanQ.add(reserSwanQ.poll());
        }
    }
    private static void meltWater() {
        while (waterQ.isEmpty() == false) {
            Pos currentPos = waterQ.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (isOutOfMap(ny, nx)) {
                    continue;
                }
                if (visitWater[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 'X') {
                    visitWater[ny][nx] = true;
                    map[ny][nx] = '.';
                    reserWaterQ.add(new Pos(ny, nx));
                    continue;
                }
                visitWater[ny][nx] = true;
                waterQ.add(new Pos(ny, nx));
            }
        }
    }
    private static boolean meetSwan() {
        while (swanQ.isEmpty() == false) {
            Pos currentPos = swanQ.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (isOutOfMap(ny, nx)) {
                    continue;
                }
                if (visitSwan[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 'L') {
                    return true;
                }
                if (map[ny][nx] == 'X') {
                    visitSwan[ny][nx] = true;
                    reserSwanQ.add(new Pos(ny, nx));
                    continue;
                }
                visitSwan[ny][nx] = true;
                swanQ.add(new Pos(ny, nx));
            }
        }
        return false;
    }

    private static boolean isOutOfMap(int ny, int nx) {
        return (ny < 0 || nx < 0 || ny >= R || nx >= C);
    }

    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        map = new char[R][C];
        visitSwan = new boolean[R][C];
        visitWater = new boolean[R][C];
        int swanY = -1;
        int swanX = -1;
        for (int r = 0; r < R; ++r) {
            String row = br.readLine();
            for (int c = 0; c < row.length(); ++c) {
                map[r][c] = row.charAt(c);
                if (map[r][c] == '.' || map[r][c] == 'L') {
                    visitWater[r][c] = true;
                    waterQ.add(new Pos(r, c));
                }
                if (map[r][c] == 'L') {
                    swanY = r;
                    swanX = c;
                }
            }
        }
        visitSwan[swanY][swanX] = true;
        swanQ.add(new Pos(swanY, swanX));
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
