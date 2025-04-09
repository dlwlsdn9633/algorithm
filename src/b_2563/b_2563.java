package b_2563;

import java.io.*;

public class b_2563 {
    private static int N;
    private static Pos leftTop = new Pos(Integer.MIN_VALUE, Integer.MAX_VALUE);
    private static Pos rightBottom = new Pos(Integer.MAX_VALUE, Integer.MIN_VALUE);
    private static int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[101][101];
        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String[] conds = br.readLine().split(" ");
            Pos leftBottom = new Pos(Integer.parseInt(conds[1]), Integer.parseInt(conds[0]));
            Pos rightTop = new Pos(Integer.parseInt(conds[1]) + 10, Integer.parseInt(conds[0]) + 10);
            for (int y = leftBottom.y; y < rightTop.y; ++y) {
                for (int x = leftBottom.x; x < rightTop.x; ++x) {
                    map[y][x] = 1;
                }
            }
            leftTop.x = Math.min(leftTop.x, leftBottom.x);
            leftTop.y = Math.max(leftTop.y, rightTop.y);
            rightBottom.x = Math.max(rightBottom.x, rightTop.x);
            rightBottom.y = Math.min(rightBottom.y, leftBottom.y);
        }

        int ret = 0;
        for (int y = rightBottom.y; y < leftTop.y; ++y) {
            for (int x = leftTop.x; x < rightBottom.x; ++x) {
                if (map[y][x] == 1) {
                    ++ret;
                }
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
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
