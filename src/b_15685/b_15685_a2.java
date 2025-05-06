package b_15685;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_15685_a2 {
    private static int N;
    private static int cnt;
    private static int[][] dirs = {
            { +0, +1 },
            { -1, +0 },
            { +0, -1 },
            { +1, +0 }
    };
    private static final int MAX_N = 105;
    private static ArrayList<Integer>[][] dragon = new ArrayList[4][11];
    private static boolean[][] map = new boolean[MAX_N][MAX_N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        makeDragon();
        for (int n = 0; n < N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            draw(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        for (int r = 0; r <= 100; ++r) {
            for (int c = 0; c <= 100; ++c) {
                if (map[r][c] && map[r + 1][c] && map[r + 1][c + 1] && map[r][c + 1]) {
                    ++cnt;
                }
            }
        }
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void draw(
            int x,
            int y,
            int d,
            int g
    ) {
        map[y][x] = true;
        for (int generation = 0; generation <= g; ++generation) {
            for (int dirIdx : dragon[d][generation]) {
                y += dirs[dirIdx][0];
                x += dirs[dirIdx][1];
                map[y][x] = true;
            }
        }
    }

    private static void makeDragon() {
        for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
            for (int generation = 0; generation <= 10; ++generation) {
                dragon[dirIdx][generation] = new ArrayList<>();
            }
        }
        for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
            dragon[dirIdx][0].add(dirIdx);
            dragon[dirIdx][1].add((dirIdx + 1) % 4);
            for (int generation = 2; generation <= 10; ++generation) {
                int lastGenerationLen = dragon[dirIdx][generation - 1].size();
                for (int lastGenerationIdx = lastGenerationLen - 1; lastGenerationIdx >= 0; --lastGenerationIdx) {
                    dragon[dirIdx][generation].add((dragon[dirIdx][generation - 1].get(lastGenerationIdx) + 1) % 4);
                }
                for (int k = 0; k < lastGenerationLen; ++k) {
                    dragon[dirIdx][generation].add(dragon[dirIdx][generation - 1].get(k));
                }
            }
        }
    }
}
