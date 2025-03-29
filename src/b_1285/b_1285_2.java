package b_1285;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// 메모리 초과
public class b_1285_2 {
    private static int N;
    private static int[][] map;
    private static int[][] reversedMap;
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);

        for (int bitNum = 0; bitNum < (1 << N); ++bitNum) {
            ArrayList<Integer> bits = new ArrayList<>();
            for (int bitIdx = 0; bitIdx < N; ++bitIdx) {
                if ((bitNum & (1 << bitIdx)) != 0) {
                    bits.add(bitIdx);
                }
            }
            for (int bit : bits) {
                reverseMapRow(bit);
                reverseReversedMapRow(bit);
            }
            dfs();
            dfsReverse();
            for (int bit : bits) {
                reverseMapRow(bit);
                reverseReversedMapRow(bit);
            }
        }

        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }

    private static void dfs() {
        int sum = 0;
        for (int j = 0; j < N; ++j) {
            int[] dp = new int[2];
            for (int i = 0; i < N; ++i) {
                ++dp[map[i][j]];
            }
            int minValue = Arrays.stream(dp).min().getAsInt();
            sum += minValue;
        }
        ret = Math.min(sum, ret);
    }
    private static void dfsReverse() {
        int sum = 0;
        for (int j = 0; j < N; ++j) {
            int[] dp = new int[2];
            for (int i = 0; i < N; ++i) {
                ++dp[reversedMap[i][j]];
            }
            int minValue = Arrays.stream(dp).min().getAsInt();
            sum += minValue;
        }
        ret = Math.min(sum, ret);
    }


    private static void reverseMapRow(int r) {
        for (int j = 0; j < N; ++j) {
            map[r][j] = (map[r][j] == 0) ? 1 : 0;
        }
    }
    private static void reverseReversedMapRow(int r) {
        for (int j = 0; j < N; ++j) {
            reversedMap[r][j] = (reversedMap[r][j] == 0) ? 1 : 0;
        }
    }
    private static void setMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        reversedMap = new int[N][N];
        for (int i = 0; i < N; ++i) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); ++j) {
                if (row.charAt(j) == 'H') {
                    map[i][j] = 1;
                    reversedMap[j][i] = 1;
                } else if (row.charAt(j) == 'T') {
                    map[i][j] = 0;
                    reversedMap[j][i] = 0;
                }
            }
        }
    }
}
