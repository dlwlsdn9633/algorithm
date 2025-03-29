package b_14391;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
*   2 3
*   123
*   312
* */
public class b_14391 {
    private static int N;
    private static int M;
    private static boolean[][] visited;
    private static boolean[][] visitedNumbers;
    private static int[][] map;
    private static int[][] reversedMap;
    private static ArrayList<Integer> numList = new ArrayList<>();
    private static int maxValue = Integer.MIN_VALUE;
    private static int[][] dirs = {
            { +1, +0 }, // y축으로 1이동
            { +0, +1 }  // x축으로 1이동
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        dfs(0);
        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
    }
    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        visited = new boolean[N][M];
        map = new int[N][M];
        visitedNumbers = new boolean[N][M];
        for (int n = 0; n < N; ++n) {
            String row = br.readLine();
            for (int x = 0; x < row.length(); ++x) {
                map[n][x] = (int)(row.charAt(x) - '0');
            }
        }
    }

    private static void dfs(int depth) {
        if (depth == N) {
            ArrayList<Integer> numbers = getNumbers();
            int sum = numbers.stream().mapToInt(x -> x).sum();
            printVisited();
            System.out.println(numbers);
            maxValue = Math.max(maxValue, sum);
            return;
        }
        for (int i = 0; i < (1 << M); ++i) {
            int[] xs = new int[M];
            for (int j = 0; j < M; ++j) {
                if ((i & (1 << j)) != 0) {
                    xs[j] = 1;
                } else {
                    xs[j] = 0;
                }
            }
            for (int x : xs) {
                visited[depth][x] = true;
                dfs(depth + 1);
                visited[depth][x] = false;
            }
        }
    }

    private static ArrayList<Integer> getNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                if (visitedNumbers[y][x] == false) {
                    visitedNumbers[y][x] = true;
                    numList.add(map[y][x]);
                    dfsNum(y, x, visited[y][x]);

                    String numStr = "";
                    for (int c : numList) {
                        numStr += String.valueOf(c);
                    }

                    int number = Integer.parseInt(numStr);
                    numList.clear();
                    numbers.add(number);
                }
            }
        }
        for (int n = 0; n < N; ++n) {
            Arrays.fill(visitedNumbers[n], false);
        }
        return numbers;
    }

    private static void dfsNum(int y, int x, boolean v) {
        for (int i = 0; i < 2; ++i) {
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }
            if (visited[ny][nx] == v) {
                numList.add(map[ny][nx]);
                visitedNumbers[ny][nx] = true;
                dfsNum(ny, nx, v);
            }
        }
    }



    private static void printVisited() {
        System.out.println();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
