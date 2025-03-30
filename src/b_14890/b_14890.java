package b_14890;

import java.io.*;

public class b_14890 {
    private static int N;
    private static int L;
    private static int[][] map;
    private static int[][] reversedMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        int sum = 0;
        for (int y = 0; y < N; ++y) {
            if (checkY(y, map)) {
                sum += 1;
            }
            if (checkY(y, reversedMap)) {
                sum += 1;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        L = Integer.parseInt(conds[1]);
        map = new int[N][N];
        reversedMap = new int[N][N];
        for (int n = 0; n < N; ++n) {
            String[] row = br.readLine().split(" ");
            for (int x = 0; x < row.length; ++x) {
                map[n][x] = Integer.parseInt(row[x]);
                reversedMap[x][n] = map[n][x];
            }
        }
    }
    private static boolean checkY(int y, int[][] map) {
        int cnt = 1; // 남은 영역
        for (int x = 0; x < N - 1; ++x) {
            if (map[y][x] == map[y][x + 1]) {
                ++cnt;
            } else if (map[y][x] == map[y][x + 1] - 1 && cnt >= L) {
                cnt = 1;
            } else if (map[y][x] == map[y][x + 1] + 1 && cnt >= 0) {
                cnt = 1 - L;
            } else {
                return false;
            }
        }
        return cnt >= 0;
    }
}
