package b_3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class b_3197 {
    private static int R;
    private static int C;
    private static char map[][];
    private static boolean visited[][];
    private static boolean[][] swanVisited;
    private static ArrayList<Pos> swansList = new ArrayList<>();
    private static Queue<Pos> waterList = new LinkedList<>();
    private static int turn = 0;
    private static int dirs[][] = {
            { +0, +1 },
            { +0, -1 },
            { +1, +0 },
            { -1, +0 }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        setMap(br);

        while (isMeet() == false) {
            Queue<Pos> temp = new LinkedList<>();
            while (waterList.isEmpty() == false) {
                Pos currentWater = waterList.poll();
                for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                    int ny = currentWater.y + dirs[dirIdx][0];
                    int nx = currentWater.x + dirs[dirIdx][1];

                    if (nx < 0 || ny < 0 || ny >= R || nx >= C) {
                        continue;
                    }
                    if (visited[ny][nx] == true) {
                        continue;
                    }
                    visited[ny][nx] = true;
                    if (map[ny][nx] == 'X') {
                        map[ny][nx] = '.';
                        temp.add(new Pos(ny, nx));
                    } else {
                        waterList.add(new Pos(ny, nx));
                    }
                }
            }
            //printMap();
            waterList = temp;
            ++turn;
        }
        System.out.println(turn);
    }
    private static void printMap() {
        System.out.println();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                System.out.print(map[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static boolean isMeet() {
        swanVisited = new boolean[R][C];
        Queue<Pos> swanQueue = new LinkedList<>();
        swanQueue.add(swansList.get(0));
        swanVisited[swansList.get(0).y][swansList.get(0).x] = true;
        while (swanQueue.isEmpty() == false) {
            Pos currentPos = swanQueue.poll();
            if (currentPos.y == swansList.get(1).y && currentPos.x == swansList.get(1).x) {
                return true;
            }
            for (int i = 0; i < 4; ++i) {
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (swanVisited[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 'X') {
                    continue;
                }
                swanVisited[ny][nx] = true;
                swanQueue.add(new Pos(ny, nx));
            }
        }
        return false;
    }

    private static void setMap(BufferedReader br) throws IOException {
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; ++r) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < C; ++c) {
                if (map[r][c] == 'L') {
                    swansList.add(new Pos(r, c));
                }
                if (map[r][c] == '.') {
                    waterList.add(new Pos(r, c));
                    visited[r][c] = true;
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
    }
}
