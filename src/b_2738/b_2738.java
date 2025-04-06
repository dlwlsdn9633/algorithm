package b_2738;

import java.io.*;

public class b_2738 {
    private static int N;
    private static int M;
    private static int[][] matrix1;
    private static int[][] matrix2;
    private static int[][] ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);

        matrix1 = new int[N][M];
        matrix2 = new int[N][M];
        ret = new int[N][M];

        for (int y = 0; y < N; ++y) {
            String[] row = br.readLine().split(" ");
            for (int x = 0; x < M; ++x) {
                matrix1[y][x] = Integer.parseInt(row[x]);
            }
        }

        for (int y = 0; y < N; ++y) {
            String[] row = br.readLine().split(" ");
            for (int x = 0; x < M; ++x) {
                matrix2[y][x] = Integer.parseInt(row[x]);
            }
        }

        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                ret[y][x] = matrix1[y][x] + matrix2[y][x];
            }
        }

        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                bw.write(ret[y][x] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
