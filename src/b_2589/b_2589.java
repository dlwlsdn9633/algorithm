package b_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class b_2589 {
    private static int walk[][];
    private static char map[][];
    private static int H;
    private static int W;
    private static ArrayList<Pos> landList = new ArrayList<>();
    private static int maxVal = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        H = Integer.parseInt(conds[0]);
        W = Integer.parseInt(conds[1]);
        setMap(br);
        for (Pos land : landList) {
            for (int h = 0; h < H; ++h) {
                Arrays.fill(walk[h], 0);
            }
            dfs(land.y, land.x, 0);
        }

    }

    private static void dfs(int y, int x, int depth) {
        if (y < 0 || x < 0 || y >= H || x >= W) {
            return;
        }
        if (map[y][x] == 'W') {
            return;
        }
        if (walk[y][x] != 0 && walk[y][x] < depth) {
            return;
        }
        walk[y][x] = depth;
        int dirs[][] = {
                { +0, +1 },
                { +0, -1 },
                { +1, +0 },
                { -1, +0 }
        };
        for (int i = 0; i < 4; ++i) {
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            dfs(ny, nx, depth + 1);
        }
    }
    private static void setMap(BufferedReader br) throws IOException {
        map = new char[H][W];
        walk = new int[H][W];
        for (int y = 0; y < H; ++y) {
            String row = br.readLine();
            for (int x = 0; x < W; ++x) {
                map[y][x] = row.charAt(x);
                if (map[y][x] == 'L') {
                    landList.add(new Pos(y, x));
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
