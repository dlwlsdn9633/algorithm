package b_2468;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class b_2468 {
    private static int N;
    private static boolean visited[][];
    private static int map[][];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();

        visited = new boolean[N][N];
        map = new int[N][N];

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = -1;
        for (int y = 0; y < N; ++y) {
            String[] row = scanner.nextLine().split(" ");
            for (int x = 0; x < row.length; ++x) {
                map[y][x] = Integer.valueOf(row[x]);
                visited[y][x] = false;
                if (map[y][x] < minHeight) {
                    minHeight = map[y][x];
                }
                if (map[y][x] > maxHeight) {
                    maxHeight = map[y][x];
                }
            }
        }

        int answer = 1;
        for (int height = minHeight; height < maxHeight; ++height) {
            // 1. 빗물 채우기
            if (height == 6) {
                int a = 3;
            }

            fillMap(height);
            // 2. candidate 구하기


            int candidate = getCandidate();

            // 3. answer와 candidate를 비교해서, answer 변경하기
            if (candidate > answer) {
                answer = candidate;
            }

            // 4. 초기화 하기
            clear();
        }
        System.out.println(answer);
    }

    private static void clear() {
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < N; ++x) {
                visited[y][x] = false;
            }
        }
    }

    private static int getCandidate() {
        int candidate = 0;
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < N; ++x) {
                if (visited[y][x] == false) {
                    bfs(y, x);
                    ++candidate;
                }
            }
        }
        return candidate;
    }

    private static void fillMap(int height) {
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < N; ++x) {
                if (visited[y][x]) {
                    continue;
                }
                if (map[y][x] <= height) {
                    bfs(y, x, height);
                }
            }
        }
    }

    private static void bfs(int y, int x) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(y, x));

        while (queue.isEmpty() == false) {
            Pos currentPos = queue.poll();
            if (currentPos.x < 0 || currentPos.y < 0 || currentPos.x >= N || currentPos.y >= N) {
                continue;
            }
            if (visited[currentPos.y][currentPos.x] == true) {
                continue;
            }

            visited[currentPos.y][currentPos.x] = true;
            int move[][] = {
                    { -1, 0 },
                    { +1, 0 },
                    { 0, -1 },
                    { 0, +1 }
            };
            for (int i = 0; i < 4; ++i) {
                queue.add(new Pos(currentPos.y + move[i][0], currentPos.x + move[i][1]));
            }
        }
    }

    private static void bfs(int y, int x, int height) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(y, x));

        while (queue.isEmpty() == false) {
            Pos currentPos = queue.poll();
            if (currentPos.x < 0 || currentPos.y < 0 || currentPos.x >= N || currentPos.y >= N) {
                continue;
            }
            if (visited[currentPos.y][currentPos.x] == true) {
                continue;
            }

            if (map[currentPos.y][currentPos.x] > height) {
                continue;
            }

            visited[currentPos.y][currentPos.x] = true;
            queue.add(new Pos(currentPos.y - 1, currentPos.x));
            queue.add(new Pos(currentPos.y + 1, currentPos.x));
            queue.add(new Pos(currentPos.y, currentPos.x - 1));
            queue.add(new Pos(currentPos.y, currentPos.x + 1));
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
