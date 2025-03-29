package b_1940;

import java.io.*;

// 왜 arraylist를 사용하면 메모리 초과가 발생하는 걸까?
public class b_1940_2 {
    private static int N;
    private static int M;
    private static int[] ingredients;
    private static int[] metals = new int[2];
    private static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ingredients = new int[N];
        String conds[] = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            ingredients[i] = Integer.parseInt(conds[i]);
        }
        dfs(-1, 0);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void dfs(int startIdx, int depth) {
        if (depth == 2) {
            int sum = 0;
            for (Integer metal : metals) {
                sum += metal;
            }
            if (sum == M) {
                ++ret;
            }
            return;
        }
        for (int i = startIdx + 1; i < N; ++i) {
            metals[depth] = ingredients[i];
            dfs(i, depth + 1);
        }
    }
}
