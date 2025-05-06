package b_15685;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class b_15685_a {
    private static int dy[] = { 0, -1, 0, 1 };
    private static int dx[] = { 1, 0, -1, 0 };
    private static int cnt;
    private static int N;
    private static int x;
    private static int y;
    private static int d;
    private static int g;
    private static ArrayList<Integer>[][] dragon = new ArrayList[4][11];
    private static int[][] map = new int[105][105];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        makeDragon();
        for (int n = 0; n < N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            go(x, y, d, g);
        }

        for (int i = 0; i <= 100; ++i) {
            for (int j = 0; j <= 100; ++j) {
                if (map[i][j] != 0 && map[i + 1][j] != 0 && map[i + 1][j + 1] != 0 && map[i][j + 1] != 0) {
                    ++cnt;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void go(int x, int y, int d, int g) {
        map[x][y] = 1;
        for (int i = 0; i <= g; ++i) {
            for (int dir : dragon[d][i]) {
                x += dx[dir];
                y += dy[dir];
                map[x][y] = 1;
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
            dragon[dirIdx][0].add(dirIdx);                  // 0 세대
            dragon[dirIdx][1].add((dirIdx + 1) % 4);        // 1 세개
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
