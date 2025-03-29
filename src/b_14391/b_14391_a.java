package b_14391;

import java.io.*;

public class b_14391_a {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        map = new int[N][M];
        for (int n = 0; n < N; ++n) {
            String row = br.readLine();
            for (int x = 0; x < row.length(); ++x) {
                map[n][x] = (int)(row.charAt(x) - '0');
            }
        }


        for (int bitNumber = 0; bitNumber < (1 << (N * M)); ++bitNumber) {
            int sum = 0;
            if (bitNumber == 12) {
                int a =3;
            }

            for (int y = 0; y < N; ++y) {
                int value = 0;
                for (int x = 0; x < M; ++x) {
                    int idx = y * M + x;
                    if ((bitNumber & (1 << idx)) == 0) {
                        value = (value * 10) + map[y][x];
                    } else {
                        sum += value;
                        value = 0;
                    }
                }
                sum += value;
            }

            for (int x = 0; x < M; ++x) {
                int value = 0;
                for (int y = 0; y < N; ++y) {
                    int idx = y * M + x;
                    if ((bitNumber & (1 << idx)) != 0) {
                        value = (value * 10) + map[y][x];
                    } else {
                        sum += value;
                        value = 0;
                    }
                }
                sum += value;
            }


            ret = Math.max(ret, sum);
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    private static void printMap() {
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                System.out.print(map[y][x] + '\t');
            }
            System.out.println();
        }
    }
}
