package b_17136;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b_17136_2 {
    private static int ret = Integer.MAX_VALUE;
    private static final int MAX_LEN = 10;
    private static final int[][] map = new int[MAX_LEN][MAX_LEN];
    private static Map<Integer, Integer> paperMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);
        dfs(0, 0, 0);
        if (ret == Integer.MAX_VALUE) {
            ret = -1;
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int y, int x, int use) {
        if (use >= ret) {
            return;
        }
        if (x == MAX_LEN) {
            dfs(y + 1, 0, use);
            return;
        }
        if (y == MAX_LEN) {
            ret = Math.min(ret, use);
            return;
        }
        if (map[y][x] == 0) {
            dfs(y, x + 1, use);
            return;
        }

        for (int _size = 5; _size >= 1; --_size) {
            if (paperMap.get(_size) == 5) {
                continue;
            }
            if (isCheck(y, x, _size)) {
                paperMap.put(_size, paperMap.get(_size) + 1);
                draw(y, x, _size, 0);
                dfs(y, x + _size, use + 1);
                draw(y, x, _size, 1);
                paperMap.put(_size, paperMap.get(_size) - 1);
            }
        }
    }
    private static void draw(int y, int x, int _size, int draw) {
        for (int i = y; i < y + _size; ++i) {
            for (int j = x; j < x + _size; ++j) {
                map[i][j] = draw;
            }
        }
    }
    private static boolean isCheck(int y, int x, int _size) {
        if (y + _size > MAX_LEN || x + _size > MAX_LEN) {
            return false;
        }
        for (int i = y; i < y + _size; ++i) {
            for (int j = x; j < x + _size; ++j) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void setMap(BufferedReader br) throws IOException {
        for (int i = 0; i < MAX_LEN; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX_LEN; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int paper = 1; paper <= 5; ++paper) {
            paperMap.putIfAbsent(paper, 0);
        }
    }
}
