package b_14502;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class b_14502 {
    private static int[][] map; // 맵
    private static boolean visited[][];
    private static int[][] tempMap;
    private static int N; // 세로 길이
    private static int M; // 가로 길이
    private static int answer = -1;

    private static ArrayDeque<Pos> selectedPos = new ArrayDeque<>();

    private static ArrayList<Pos> emptyPositions = new ArrayList<>();
    private static ArrayList<Pos> virusPositions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");
        N = Integer.valueOf(conds[0]);
        M = Integer.valueOf(conds[1]);


        map = new int[N][M];
        tempMap = new int[N][M];
        visited = new boolean[N][M];

        setMap(scanner);
        dfs(-1, 0);
        System.out.println(answer);
    }

    private static void setMap(Scanner scanner) {
        for (int i = 0; i < N; ++i) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < row.length; ++j) {
                map[i][j] = Integer.valueOf(row[j]);
                visited[i][j] = false;
                if (map[i][j] == 0) {
                    emptyPositions.add(new Pos(i, j));
                } else if (map[i][j] == 2) {
                    virusPositions.add(new Pos(i, j));
                }
            }
        }
    }

    private static void storeMap() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                tempMap[i][j] = map[i][j];
                visited[i][j] = false;
            }
        }
    }
    private static void rollbackMap() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                map[i][j] = tempMap[i][j];
                visited[i][j] = false;
            }
        }
    }

    private static void dfs(int startIdx, int depth) {
        if (depth == 3) {
            storeMap();
            int ret = virusTest();
            answer = (answer < ret) ? ret : answer;
            rollbackMap();

            return;
        }

        for (int i = startIdx + 1; i < emptyPositions.size(); ++i) {
            Pos emptyPosition = emptyPositions.get(i);
            map[emptyPosition.y][emptyPosition.x] = 1;
            selectedPos.add(new Pos(emptyPosition.y, emptyPosition.x));

            dfs(i, depth + 1);
            map[emptyPosition.y][emptyPosition.x] = 0;
            selectedPos.remove();
        }
    }

    private static int virusTest() {
        Queue<Pos> q = new ArrayDeque<>();
        for (Pos virusPos : virusPositions) {
            q.add(new Pos(virusPos.y, virusPos.x));
        }

        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();
            if (currentPos.y < 0 || currentPos.x < 0 || currentPos.y >= N || currentPos.x >= M) {
                continue;
            }

            if (visited[currentPos.y][currentPos.x] == true) {
                continue;
            }

            if (map[currentPos.y][currentPos.x] == 1) {
                continue;
            }

            map[currentPos.y][currentPos.x] = 2;
            visited[currentPos.y][currentPos.x] = true;

            int[][] dirs = {
                    { 0, 1 },
                    { 0, -1 },
                    { 1, 0 },
                    { -1, 0}
            };
            for (int i = 0; i < 4; ++i) {
                int dy = dirs[i][0];
                int dx = dirs[i][1];
                q.add(new Pos(currentPos.y + dy, currentPos.x + dx));
            }
        }

        return getEmptyRoomNumbers();
    }

    private static int getEmptyRoomNumbers() {
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] == 0)
                {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    private static void printMap() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public String toString() {
            return "(" + y + ", " + x + ")";
        }
    }
}
