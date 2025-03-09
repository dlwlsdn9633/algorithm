package b_2178;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class b_2178_bfs {
    private static int N;
    private static int M;
    private static int map[][];
    private static int depthMap[][];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cond = scanner.nextLine().split(" ");
        N = Integer.valueOf(cond[0]);
        M = Integer.valueOf(cond[1]);

        map = new int[N + 1][M + 1];
        depthMap = new int[N + 1][M + 1];

        for (int i = 1; i <= N; ++i) {
            String row = scanner.nextLine();
            char[] rowArr = row.toCharArray();
            for (int j = 0; j < M; ++j) {
                map[i][j + 1] = Integer.valueOf(rowArr[j] - '0');
                depthMap[i][j + 1] = Integer.MAX_VALUE;
            }
        }

        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(1, 1, 1));

        while (queue.isEmpty() == false) {
            Pos currentPos = queue.poll();
            if (currentPos.x < 1 || currentPos.y < 1 || currentPos.x > N || currentPos.y > M) {
                continue;
            }
            if (map[currentPos.x][currentPos.y] == 0) {
                continue;
            }
            if (depthMap[currentPos.x][currentPos.y] > currentPos.depth) {
                depthMap[currentPos.x][currentPos.y] = currentPos.depth;

                //System.out.println(currentPos.toString());

                queue.add(new Pos(currentPos.x - 1, currentPos.y, currentPos.depth + 1));
                queue.add(new Pos(currentPos.x, currentPos.y - 1, currentPos.depth + 1));
                queue.add(new Pos(currentPos.x + 1, currentPos.y, currentPos.depth + 1));
                queue.add(new Pos(currentPos.x, currentPos.y + 1, currentPos.depth + 1));
            }
        }

        System.out.println(depthMap[N][M]);
    }

    static class Pos {
        public int x;
        public int y;
        public int depth;
        public Pos(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public String toString() {
            return "(x: " + x + ", y: " + y + ", depth: " + depth + ")";
        }
    }
}
