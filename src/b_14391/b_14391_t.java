package b_14391;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_14391_t {
    private static int N;
    private static int M;
    private static boolean[][] visited;
    private static boolean[][] selected;
    private static int[][] map;
    private static int[][] dirs = {
            { +1, +0 },
            { +0, +1 }
    };
    private static Queue<Integer> numQueue = new LinkedList<>();
    private static int ret = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        selectedDfs(0);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);

        selected = new boolean[N][M];
        visited = new boolean[N][M];
        map = new int[N][M];

        for (int n = 0; n < N; ++n) {
            String row = br.readLine();
            for (int rowIdx = 0; rowIdx < row.length(); ++rowIdx) {
                map[n][rowIdx] = (int)(row.charAt(rowIdx) - '0');
            }
        }
    }
    private static int getSum() {
        for (int y = 0; y < N; ++y) {
            Arrays.fill(visited[y], false);
        }
        ArrayList<Integer> numList = new ArrayList<>();
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                // y, x 기준으로 num을 가져와 저장한다
                if (visited[y][x] == false) {
                    visited[y][x] = true;
                    numQueue.add(map[y][x]);
                    for (int dirIdx = 0; dirIdx < 2; ++dirIdx) {
                        int ny = y + dirs[dirIdx][0];
                        int nx = x + dirs[dirIdx][1];
                        if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                            continue;
                        }
                        if (visited[ny][nx]) {
                            continue;
                        }
                        if (selected[y][x] != selected[ny][nx]) {
                            continue;
                        }
                        setNumList(y, x, selected[y][x], dirIdx);
                    }
                    String numStr = "";
                    while (numQueue.isEmpty() == false) {
                        numStr += String.valueOf(numQueue.poll());
                    }
                    numList.add(Integer.parseInt(numStr));
                }
            }
        }
        return numList.stream().mapToInt(x -> x).sum();
    }

    private static void setNumList(int y, int x, boolean v, int dirIdx) {
        int ny = y + dirs[dirIdx][0];
        int nx = x + dirs[dirIdx][1];
        if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
            return;
        }
        if (visited[ny][nx] == true) {
            return;
        }
        if (selected[ny][nx] != v) {
            return;
        }
        visited[ny][nx] = true;
        numQueue.add(map[ny][nx]);
        setNumList(ny, nx, v, dirIdx);
    }

    private static void selectedDfs(int depth) {
        if (depth == N) {
            if (isValidMatrix()) {
                int sum = getSum();
                ret = Math.max(sum, ret);
            }
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
            for (int j = 0; j < M; ++j) {
                selected[depth][j] = (xs[j] == 1) ? true : false;
            }
            selectedDfs(depth + 1);
        }
    }
    private static void printSelected() {
        System.out.println();
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                System.out.print(selected[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidMatrix() {

        for (int y = 0; y < N - 1; ++y) {
            for (int x = 0; x < M - 1; ++x) {
                boolean currentSelected = selected[y][x];
                boolean rightSelected = selected[y][x + 1];
                boolean bottomSelected = selected[y + 1][x];

                boolean rightCheck = currentSelected == rightSelected;
                boolean bottomCheck = currentSelected == bottomSelected;

                if (rightCheck && bottomCheck) {
                    return false;
                }
            }
        }
        return true;
    }

}
