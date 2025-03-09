package b_3197;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_3197_a {
    private static int max_n = 1501;
    private static char[][] map;
    private static int R;
    private static int C;
    private static int swanY;
    private static int swanX;
    private static boolean[][] visited;
    private static boolean[][] visited_swan;
    private static Queue<Pos> swanQ = new LinkedList<>();
    private static Queue<Pos> swanTempQ = new LinkedList<>();
    private static Queue<Pos> waterQ = new LinkedList<>();
    private static Queue<Pos> waterTempQ = new LinkedList<>();
    private static int[][] dirs = {
            { +0, +1 },
            { +0, -1 },
            { +1, +0 },
            { -1, +0 }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap(br);

        int day = 0;
        while (true) {
            if (meet_swan()) {
                break;
            }
            water_melt();
            deepCopy();
            //printMap();
            ++day;
        }
        System.out.println(day);

    }
    private static void deepCopy() {
        while (waterTempQ.isEmpty() == false) {
            waterQ.add(waterTempQ.poll());
        }
        while (swanTempQ.isEmpty() == false) {
            swanQ.add(swanTempQ.poll());
        }
    }

    private static void water_melt() {
        while (waterQ.isEmpty() == false) {
            Pos currentWater = waterQ.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = currentWater.y + dirs[i][0];
                int nx = currentWater.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;
                if (map[ny][nx] == 'X') {
                    waterTempQ.add(new Pos(ny, nx));
                    map[ny][nx] = '.';
                } else {
                    waterQ.add(new Pos(ny, nx));
                }
            }
        }
    }

    private static boolean meet_swan() {
        while (swanQ.isEmpty() == false) {
            Pos swanPos = swanQ.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = swanPos.y + dirs[i][0];
                int nx = swanPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (visited_swan[ny][nx]) {
                    continue;
                }
                visited_swan[ny][nx] = true;
                if (map[ny][nx] == '.') {
                    swanQ.add(new Pos(ny, nx));
                } else if (map[ny][nx] == 'X') {
                    swanTempQ.add(new Pos(ny, nx));
                } else if (map[ny][nx] == 'L') {
                    return true;
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
        visited = new boolean[R][C];
        visited_swan = new boolean[R][C];

        for (int r = 0; r < R; ++r) {
            String row = br.readLine();
            for (int c = 0; c < C; ++c) {
                map[r][c] = row.charAt(c);
                if (map[r][c] == '.' || map[r][c] == 'L') {
                    visited[r][c] = true;
                    waterQ.add(new Pos(r, c));
                }
                if (map[r][c] == 'L') {
                    swanY = r;
                    swanX = c;
                }
            }
        }
        visited_swan[swanY][swanX] = true;
        swanQ.add(new Pos(swanY, swanX));
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

    static class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
