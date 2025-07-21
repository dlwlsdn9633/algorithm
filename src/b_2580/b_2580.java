package b_2580;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class b_2580 {
    private final static int MAX_LEN = 9;
    private static int[][] map = new int[MAX_LEN][MAX_LEN];
    private static List<Pos> emptyPosList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        dfs(0, bw);

        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int depth, BufferedWriter bw) throws IOException {
        if (depth == emptyPosList.size()) {
            printAnswer(bw);
            System.exit(0);
        }
        Pos currentEmptyPos = emptyPosList.get(depth);
        for (int num = 1; num <= 9; ++num) {
            boolean validRow = isValidRow(currentEmptyPos.y, num);
            boolean validCol = isValidCol(currentEmptyPos.x, num);
            boolean validArea = isValidArea(currentEmptyPos.y, currentEmptyPos.x, num);
            if (validRow && validCol && validArea) {
                map[currentEmptyPos.y][currentEmptyPos.x] = num;
                dfs(depth + 1, bw);
                map[currentEmptyPos.y][currentEmptyPos.x] = 0;
            }
        }
    }
    private static boolean isValidRow(int y, int num) {
        for (int c = 0; c < MAX_LEN; ++c) {
            if (num == map[y][c]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isValidCol(int x, int num) {
        for (int r = 0; r < MAX_LEN; ++r) {
            if (num == map[r][x]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isValidArea(int y, int x, int num) {
        for (int i = (3 * (y / 3)); i < (3 * ((y / 3) + 1)); ++i) {
            for (int j = (3 * (x / 3)); j < (3 * ((x / 3) + 1)); ++j) {
                if (num == map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void setConds(BufferedReader br) throws IOException {
        for (int y = 0; y < MAX_LEN; ++y) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < MAX_LEN; ++x) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 0) {
                    emptyPosList.add(new Pos(y, x));
                }
            }
        }
    }
    private static void printAnswer(BufferedWriter bw) throws IOException {
        for (int i = 0; i < MAX_LEN; ++i) {
            for (int j = 0; j < MAX_LEN; ++j) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    static class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
