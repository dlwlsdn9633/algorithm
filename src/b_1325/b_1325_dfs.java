package b_1325;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class b_1325_dfs {
    private static ArrayList<Integer>[] adj;
    private static boolean visited[];
    private static ArrayList<Integer> dp = new ArrayList<>();
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String conds[] = bf.readLine().split(" ");
        int N = Integer.parseInt(conds[0]);
        int M = Integer.parseInt(conds[1]);

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int m = 0; m < M; ++m) {
            String coms[] = bf.readLine().split(" ");
            int from = Integer.parseInt(coms[0]);
            int to = Integer.parseInt(coms[1]);
            adj[to].add(from);
        }

        for (int com = 1; com <= N; ++com) {
            dfs(com);
            dp.add(cnt);
            visited = new boolean[N + 1];
            cnt = 0;
        }

        //int mx = Arrays.stream(dp).max().getAsInt();
        int mx = Collections.max(dp);

        for (int i = 0; i < N; ++i) {
            if (dp.get(i) == mx) {
                bw.write((i + 1) + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int here) {
        visited[here] = true;
        for (int there : adj[here]) {
            if (visited[there] == true) {
                continue;
            }
            ++cnt;
            dfs(there);
        }
    }
}
