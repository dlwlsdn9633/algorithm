package b_9934;

import java.io.*;
import java.util.ArrayList;

public class b_9934_a2 {
    private static int K;
    private static ArrayList<Integer>[] tree;
    private static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        int end = (int)Math.pow(2, K) - 2;
        tree = new ArrayList[K + 1];
        for (int i = 0; i < K + 1; ++i) {
            tree[i] = new ArrayList<>();
        }
        setValues(br);
        dfs(0, end, 0);
        for (int depth = 0; depth < K; ++depth) {
            for (Integer value : tree[depth]) {
                bw.write(value + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    private static void dfs(int start, int end, int depth) {
        if (start > end) {
            return;
        }
        if (start == end) {
            tree[depth].add(values[start]);
            return;
        }
        int mid = (start + end) / 2;
        tree[depth].add(values[mid]);
        dfs(start, mid - 1, depth + 1);
        dfs(mid + 1, end, depth + 1);
    }
    private static void setValues(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        values = new int[conds.length];
        for (int i = 0; i < conds.length; ++i) {
            values[i] = Integer.parseInt(conds[i]);
        }
    }
}
