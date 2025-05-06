package b_15683;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class b_15683_a {
    private static int n;
    private static int m;
    private static int[][] a = new int[10][10];
    private static int[][] tmep = new int[10][10];
    private static int ret = Integer.MAX_VALUE;
    private static List<Pos> v = new ArrayList<>();
    private static int[][] dirs = {
            { -1, +0 },
            { +0, +1 },
            { +1, +0 },
            { +0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);

        bw.flush();
        bw.close();
        br.close();
    }
    // here? : camera 수
    private static void dfs(int here) {
        if (here == v.size()) {
            return;
        }
        // k는?
        for (int k = 0; k < 4; ++k) {
            List<Pos> _change = extendCCTV(here, k);
            dfs(here + 1);
            // 원래대로 복귀
            for (Pos b : _change) {
                a[b.r][b.c] = 0;
            }
        }
    }
    // here: 현재 camera
    // k: ? rotate정보를 나타내는 건가?
    private static List<Pos> extendCCTV(int here, int dir) {
        List<Pos> _change = new ArrayList<>();
        // 현재 camera의 위치 정보를 가지고 온다.
        int y = v.get(here).r;
        int x = v.get(here).c;
        if (a[y][x] == 1) {

        }
        return null;
    }

    private static void setConds(BufferedReader br) throws IOException {
        for (int r = 0; r < n; ++r) {
            String[] rows = br.readLine().split(" ");
            for (int c = 0; c < rows.length; ++c) {
                a[r][c] = Integer.parseInt(rows[c]);
                if (a[r][c] != 6 && a[r][c] != 0) {
                    v.add(new Pos(r, c));
                }
            }
        }
    }
    static class Pos {
        int r;
        int c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
