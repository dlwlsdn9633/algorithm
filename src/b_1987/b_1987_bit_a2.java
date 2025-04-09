package b_1987;
import java.io.*;
public class b_1987_bit_a2 {
    private static int R;
    private static int C;
    private static int ret = Integer.MIN_VALUE;
    private static char[][] map = new char[21][21];
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
        go(0, 0, (1 << (map[0][0] - 'A')), 1);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void go(int y, int x, int mask, int cnt) {
        ret = Math.max(ret, cnt);
        for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
            int ny = y + dirs[dirIdx][0];
            int nx = x + dirs[dirIdx][1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                continue;
            }
            int _next = (1 << (map[ny][nx] - 'A'));
            if ((mask & _next) == 0) {
                go(ny, nx, mask | _next, cnt + 1);
            }
        }
    }
    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        for (int r = 0; r < R; ++r) {
            map[r] = br.readLine().toCharArray();
        }
    }
}
