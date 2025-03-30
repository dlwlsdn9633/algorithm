package b_14890;

import java.io.*;

public class b_14890_a_3 {
    private static int N;
    private static int L;
    private static int ret = 0;
    private static int[][] map;
    private static int[][] reversedMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        go(map);
        go(reversedMap);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
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
    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        L = Integer.parseInt(conds[1]);
        map = new int[N + 1][N + 1];
        reversedMap = new int[N + 1][N + 1];
        for (int i = 0; i < N; ++i) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(row[j]);
                reversedMap[j][i] = map[i][j];
            }
        }
    }
}
