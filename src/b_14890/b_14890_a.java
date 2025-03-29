package b_14890;

import java.io.*;

public class b_14890_a {
    private static int[][] a = new int[104][104];
    private static int[][] b = new int[104][104];
    private static int N;
    private static int L;
    private static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        go(a);
        go(b);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        L = Integer.parseInt(conds[1]);
        for (int i = 0; i < N; ++i) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < row.length; ++j) {
                a[i][j] = Integer.parseInt(row[j]);
                b[j][i] = a[i][j];
            }
        }
    }
    private static void go(int[][] map) {
        for (int i = 0; i < N; ++i) {
            int cnt = 1;
            int j = 0;
            for (j = 0; j < N - 1; ++j) {
                if (map[i][j] == map[i][j + 1]) {
                    ++cnt;
                } else if ((map[i][j] + 1 == map[i][j + 1]) && cnt >= L) {
                    cnt = 1;
                } else if ((map[i][j] - 1 == map[i][j + 1]) && cnt >= 0) {
                    cnt = -L + 1;
                } else {
                    break;
                }
            }
            if (j == N - 1 && cnt >= 0) {
                ++ret;
            }
        }
    }
}
