package b_2583;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class b_2583 {
    private static ArrayList<Integer> areas = new ArrayList<>();
    private static int ret = 0;
    private static int area = 0;
    private static boolean map[][];
    private static int M;
    private static int N;
    private static int K;
    private static int dy[] = { 0, 0, -1, 1 };
    private static int dx[] = { 1, -1, 0, 0 };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");
        M = Integer.valueOf(conds[0]);
        N = Integer.valueOf(conds[1]);
        K = Integer.valueOf(conds[2]);

        map = new boolean[M][N];
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                map[i][j] = false;
            }
        }


        for (int t = 0; t < K; ++t) {
            String[] rect = scanner.nextLine().split(" ");
            Pos leftTop = new Pos(Integer.valueOf(rect[0]), Integer.valueOf(rect[1]));
            Pos rightBottom = new Pos(Integer.valueOf(rect[2]), Integer.valueOf(rect[3]));

            fillRects(leftTop, rightBottom);
        }

        for (int y = 0; y < M; ++y) {
            for (int x = 0; x < N; ++x) {
                if (map[y][x] == false) {
                    dfs(y, x);
                    ++ret;
                    areas.add(area);
                    area = 0;
                }
            }
        }

        System.out.println(ret);
        areas.sort(Comparator.comparingInt(x -> x));
        for (Integer area : areas) {
            System.out.print(area + " ");
        }
    }
    private static void fillRects(Pos leftTop, Pos rightBottom) {
        for (int y = leftTop.y; y < rightBottom.y; ++y) {
            for (int x = leftTop.x; x < rightBottom.x; ++x) {
                map[y][x] = true;
            }
        }
    }

    private static void dfs(int y, int x) {
        if (y < 0 || x < 0 || y >= M || x >= N) {
            return;
        }

        if (map[y][x] == true) {
            return;
        }
        map[y][x] = true;
        ++area;
        for (int i = 0; i < 4; ++i) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            dfs(ny, nx);
        }
    }

    static class Pos {
        int y;
        int x;
        public Pos(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
}
