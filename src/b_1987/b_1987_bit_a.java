package b_1987;

import java.io.*;
public class b_1987_bit_a {
    private static char[][] map = new char[21][21];
    private static int[][] dirs = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    private static int R;
    private static int C;
    private static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        go(0, 0, (1 << (map[0][0] - 'A')), 1); // 오 visited를 사용하지 않고도, 비트마스킹으로 가능하네..
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        for (int r = 0; r < R; ++r) {
            String row = br.readLine();
            map[r] = row.toCharArray();
        }

    }
    private static void go(int y, int x, int num, int cnt) {
        ret = Math.max(ret, cnt);
        for (int i = 0; i < 4; ++i) {
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                continue;
            }
            int _next = (1 << (map[ny][nx] - 'A'));
            if ((num & _next) == 0) {
                go(ny, nx, num | _next, cnt + 1);
            }
        }
    }
}
