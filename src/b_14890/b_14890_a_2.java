package b_14890;

import java.io.*;

public class b_14890_a_2 {
    private static int N;
    private static int L;
    private static int ret = 0;
    private static int[][] a;
    private static int[][] b;
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
    private static void go(int[][] map) {
        for (int i = 0; i < N; ++i) {
            int cnt = 1;
            int j = 0;
            for (j = 0; j < N - 1; ++j) {
                if (map[i][j] == map[i][j + 1]) {
                    ++cnt; // cnt에 1를 더하고 j + 1를 한다. 그리고 iteration이 끝난다. => 즉, j + 1에는 j의 cnt 보다 1 더 큰 cnt를 가지고 있다.
                } else if ((map[i][j] + 1 == map[i][j + 1]) && cnt >= L) {
                    cnt = 1; // cnt를 1로 변환하고 -> j + 1를 한다. 그리고 iteration이 끝난다. => 즉, j + 1에 cnt 가 1이라는 의미
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
        a = new int[N + 1][N + 1];
        b = new int[N + 1][N + 1];
        for (int i = 0; i < N; ++i) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                a[i][j] = Integer.parseInt(row[j]);
                b[j][i] = a[i][j];
            }
        }
    }
}
