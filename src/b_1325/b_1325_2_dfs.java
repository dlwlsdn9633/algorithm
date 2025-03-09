package b_1325;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class b_1325_2_dfs {
    private static int N;
    private static int M;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        dp = new int[N + 1];
        graph = new ArrayList<ArrayList<Integer>>();
        for (int n = 0; n <= N; ++n) {
            graph.add(new ArrayList<>());
        }
        for (int m = 0; m < M; ++m) {
            String[] coms = br.readLine().split(" ");
            int from = Integer.parseInt(coms[0]);
            int to = Integer.parseInt(coms[1]);
            graph.get(from).add(to);
        }
        for (int com = 1; com <= N; ++com) {
            visited = new boolean[N + 1];
            dfs(com);
        }

        int maxValue = Arrays.stream(dp).max().getAsInt();
        for (int com = 1; com <= N; ++com) {
            if (dp[com] == maxValue) {
                bw.write(com + " ");
            }
        }

        bw.flush();
        bw.close();
    }
    private static void dfs(int startCom) {
        visited[startCom] = true;
        for (int child : graph.get(startCom)) {
            if (visited[child]) {
                continue;
            }
            visited[child] = true;
            ++dp[child];
            dfs(child);
        }
    }
}
