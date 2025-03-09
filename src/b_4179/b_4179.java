package b_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_4179 {
    private static int R;
    private static int C;
    private static Queue<Pos> jq = new LinkedList<>();
    private static Queue<Pos> fq = new LinkedList<>();
    private static ArrayList<Pos> exit = new ArrayList<>();
    private static char map[][];
    private static boolean visited[][];
    private static int dirs[][] = {
            { +1, +0 },
            { -1, +0 },
            { +0, -1 },
            { +0, +1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = bf.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        setMap(bf);

        boolean flag = false;
        int turn = 0;
        for (int h = 0; h < R; ++h) {
            Arrays.fill(visited[h], false);
        }

        while (true) {
            while (jq.size() != 0 && jq.peek().turn == turn) {
                Pos currentPos = jq.poll();
                if (includeExit(currentPos)) {
                    flag = true;
                    break;
                }

                visited[currentPos.y][currentPos.x] = true;
                for (int i = 0; i < 4; ++i) {
                    int ny = currentPos.y + dirs[i][0];
                    int nx = currentPos.x + dirs[i][1];
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }
                    if (visited[ny][nx] == true) {
                        continue;
                    }
                    if (map[ny][nx] == 'F') {
                        continue;
                    }
                    if (map[ny][nx] == '#') {
                        continue;
                    }
                    jq.add(new Pos(ny, nx, currentPos.turn + 1));
                }
            }

            while (fq.size() != 0 && fq.peek().turn == turn) {
                Pos currentPos = fq.poll();
                map[currentPos.y][currentPos.x] = 'F';
                for (int i = 0; i < 4; ++i) {
                    int ny = currentPos.y + dirs[i][0];
                    int nx = currentPos.x + dirs[i][1];
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }
                    if (map[ny][nx] == 'F') {
                        continue;
                    }
                    if (map[ny][nx] == '#') {
                        continue;
                    }
                    fq.add(new Pos(ny, nx, currentPos.turn + 1));
                }
            }
            if (flag || jq.size() == 0) {
                break;
            }
            ++turn;
        }

        if (flag == false) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(turn + 1);
        }
    }

    private static void printMap() {
        System.out.println();
        for (int y = 0; y < R; ++y) {
            for (int x = 0; x < C; ++x) {
                System.out.print(map[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean includeExit(Pos currentPos) {
        for (Pos pos : exit) {
            if (currentPos.y == pos.y && currentPos.x == pos.x) {
                return true;
            }
        }
        return false;
    }

    private static void setMap(BufferedReader br) throws IOException {
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int y = 0; y < R; ++y) {
            String row = br.readLine();
            for (int x = 0; x < C; ++x) {
                map[y][x] = row.charAt(x);

                if (map[y][x] == 'J') {
                    jq.add(new Pos(y, x));
                }
                if (map[y][x] == 'F') {
                    fq.add(new Pos(y, x));
                }

                if (map[y][x] == '.' && (y == 0 || y == R - 1)) {
                    exit.add(new Pos(y, x));
                }
                if (map[y][x] == '.' && (x == 0 || x == C - 1)) {
                    exit.add(new Pos(y, x));
                }
            }
        }
    }
    static class Pos {
        int y;
        int x;
        int turn;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
            this.turn = 0;
        }
        public Pos(int y, int x, int turn) {
            this.y = y;
            this.x = x;
            this.turn = turn;
        }
    }
}
