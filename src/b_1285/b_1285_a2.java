package b_1285;

import java.io.*;

public class b_1285_a2 {
    private static int N;
    private static int[] arr = new int[21];
    private static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        setArr(br);
        dfs(1);
        bw.write(String.valueOf(minValue));
        bw.flush();
        bw.close();
    }
    private static void setArr(BufferedReader br) throws IOException {
        for (int i = 1; i <= N; ++i) {
            String str = br.readLine();
            int value = 1;
            for (int j = 0; j < str.length(); ++j) {
                if (str.charAt(j) == 'T') {
                    arr[i] += value;
                }
                value *= 2;
            }
        }
    }

    private static void dfs(int row) {
        if (row == N + 1) {
            int sum = 0;
            // if (N == 3) -> 001 010 100 이런 경우를 살펴본다
            for (int colBit = 1; colBit <= (1 << (N - 1)); colBit *= 2) {
                int ret = 0;
                // if (N == 3) -> 총 3개의 행에 대해 돌아보면서 1인 경우를 ret에 더한다.
                for (int rowIdx = 1; rowIdx <= N; ++rowIdx) {
                    if ((arr[rowIdx] & colBit) != 0) {
                        ++ret;
                    }
                }
                sum += Math.min(ret, N - ret); // 1인 경우 vs 0인 경우 비교해서 가장 작은 수를 sum에 더한다.
            }
            minValue = Math.min(minValue, sum);
            return;
        }
        dfs(row + 1);
        arr[row] = ~arr[row];
        dfs(row + 1);
    }

}
