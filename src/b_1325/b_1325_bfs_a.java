package b_1325;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_1325_bfs_a {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int n = Integer.parseInt(conds[0]);
        int m = Integer.parseInt(conds[1]);

        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        // 여기는 from과 to를 반대로 해서 문제를 풀었네
        for (int i = 0; i < m; ++i) {
            String[] fromTo = br.readLine().split(" ");
            int from = Integer.parseInt(fromTo[0]);
            int to = Integer.parseInt(fromTo[1]);
            graph.get(from).add(to);
        }
        dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            visited = new boolean[n + 1];
            getMaxPen(i);
        }

        int max = 0;
        for (int i = 1; i <= n; ++i) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(Arrays.toString(dp));

        for (int com = 1; com <= n; ++com) {
            if (dp[com] == max) {
                bw.write(com + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void getMaxPen(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int value : graph.get(front)) {
                if (visited[value] == true) {
                    continue;
                }
                visited[value] = true;
                q.add(value);
                dp[value]++;
            }
        }
    }
}
