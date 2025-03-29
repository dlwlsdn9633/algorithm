package b_1012;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_1012_2 {
    private static int T;
    private static int[][] dirs = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int result = testcase(br);
            bw.write(result + "\n");
        }


        bw.flush();
        bw.close();
    }

    private static int testcase(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        int M = Integer.parseInt(conds[0]);
        int N = Integer.parseInt(conds[1]);
        int K = Integer.parseInt(conds[2]);
        int map[][] = new int[N][M];
        int result = 0;

        for (int n = 0; n < N; ++n) {
            Arrays.fill(map[n], 0);
        }

        for (int k = 0; k < K; ++k) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            map[y][x] = 1;
        }

        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                if (map[y][x] == 1) {
                    Queue<Pos> q = new LinkedList<>();
                    q.add(new Pos(y, x));
                    map[y][x] = 0;

                    while (q.isEmpty() == false) {
                        Pos currentPos = q.poll();
                        for (int i = 0; i < 4; ++i) {
                            int ny = currentPos.y + dirs[i][0];
                            int nx = currentPos.x + dirs[i][1];
                            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                                continue;
                            }
                            if (map[ny][nx] == 0) {
                                continue;
                            }
                            map[ny][nx] = 0;
                            q.add(new Pos(ny, nx));
                        }
                    }
                    ++result;
                }
            }
        }
        return result;
    }

    static class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
