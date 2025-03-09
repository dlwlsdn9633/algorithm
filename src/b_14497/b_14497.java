package b_14497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Queue를 1개 쓰는 방법
public class b_14497 {
    private static int N;
    private static int M;
    private static char map[][];
    private static boolean visited[][];
    private static int turn = 1;
    private static Pos junanPos;
    private static Pos thiefPos;
    private static boolean isCatch = false;
    private static int[][] dirs = {
            { +0, +1 },
            { +0, -1 },
            { +1, +0 },
            { -1, +0 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        String[] poses = br.readLine().split(" ");
        junanPos = new Pos(Integer.parseInt(poses[0]), Integer.parseInt(poses[1]));
        thiefPos = new Pos(Integer.parseInt(poses[2]), Integer.parseInt(poses[3]));
        setMap(br);

        Queue<Pos> q = new LinkedList<>();

        while (true) {
            q.add(new Pos(junanPos.y, junanPos.x));
            visited[junanPos.y][junanPos.x] = true;

            while (q.isEmpty() == false) {
                Pos currentPos = q.poll();
                for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                    Pos nextPos = new Pos(
                            currentPos.y + dirs[dirIdx][0],
                            currentPos.x + dirs[dirIdx][1]
                    );
                    if (nextPos.y < 1 || nextPos.x < 1 || nextPos.y > N || nextPos.x > M) {
                        continue;
                    }
                    if (visited[nextPos.y][nextPos.x] == true) {
                        continue;
                    }
                    if (map[nextPos.y][nextPos.x] == '1') {
                        map[nextPos.y][nextPos.x] = '0';
                        visited[nextPos.y][nextPos.x] = true;
                        continue;
                    }
                    if (map[nextPos.y][nextPos.x] == '#') {
                        isCatch = true;
                    }
                    visited[nextPos.y][nextPos.x] = true;
                    q.add(nextPos);
                }
                if (isCatch) {
                    break;
                }
            }

            if (isCatch) {
                break;
            }
            for (int y = 0; y <= N; ++y) {
                Arrays.fill(visited[y], false);
            }
            ++turn;
        }
        System.out.println(turn);
    }

    private static void printMap() {
        System.out.println();
        for (int y = 1; y <= N; ++y) {
            for (int x = 1; x <= M; ++x) {
                System.out.print(map[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void setMap(BufferedReader br) throws IOException {
        map = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int y = 1; y <= N; ++y) {
            String row = br.readLine();
            for (int x = 0; x < row.length(); ++x) {
                map[y][x + 1] = row.charAt(x);
            }
        }
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
