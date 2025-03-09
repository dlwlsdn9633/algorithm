package b_16234;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class b_16234 {
    private static int N;
    private static int L;
    private static int R;
    private static int map[][];
    private static boolean visited[][];
    private static ArrayList<Pos> nations = new ArrayList<>();
    private static int dirs[][] = {
            { +0, +1 },
            { +0, -1 },
            { +1, +0 },
            { -1, +0 }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String conds[] = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        L = Integer.parseInt(conds[1]);
        R = Integer.parseInt(conds[2]);
        setMap(br);

        int day = 0;
        boolean flag = false;
        while (true) {
            flag = false;
            for (int h = 0; h < N; ++h) {
                Arrays.fill(visited[h], false);
            }
            for (int y = 0; y < N; ++y) {
                for (int x = 0; x < N; ++x) {
                    if (visited[y][x] == false) {
                        nations.clear();
                        nations.add(new Pos(y, x));
                        visited[y][x] = true;
                        dfs(y, x);

                        if (nations.size() == 1) {
                            continue;
                        }
                        int sum = 0;
                        for (Pos nation : nations) {
                            sum += map[nation.y][nation.x];
                        }
                        int avg = sum / nations.size();
                        for (Pos nation : nations) {
                            map[nation.y][nation.x] = avg;
                        }
                        flag = true;
                    }
                }
            }
            if (flag == false) {
                break;
            }
            ++day;
        }

        System.out.println(day);
    }

    private static void printMap() {
        System.out.println();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; ++i) {
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            int diff = Math.abs(map[ny][nx] - map[y][x]);
            if (diff >= L && diff <= R) {
                visited[ny][nx] = true;
                nations.add(new Pos(ny, nx));
                dfs(ny, nx);
            }
        }
    }
    private static void setMap(BufferedReader br) throws IOException {
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int y = 0; y < N; ++y) {
            String[] row = br.readLine().split(" ");
            for (int x = 0; x < row.length; ++x) {
                map[y][x] = Integer.valueOf(row[x]);
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
