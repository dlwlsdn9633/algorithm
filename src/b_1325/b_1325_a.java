package b_1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1325_a {
    private static int N;
    private static int M;
    private static int mx;
    private static ArrayList<Integer>[] computers = new ArrayList[10004];
    private static int dp[] = new int[10004];
    private static boolean visited[] = new boolean[10004];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int com = 1; com <= N; ++com) {
            computers[com] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            computers[B].add(A);
        }

        for (int com = 1; com <= N; ++com) {
            Arrays.fill(visited, false);
            dp[com] = dfs(com);
            mx = Math.max(mx, dp[com]);
        }

        for (int com = 1; com <= N; ++com) {
            if (mx == dp[com]) {
                System.out.print(com + " ");
            }
        }
    }
    private static int dfs(int here) {
        visited[here] = true;
        int ret = 1;
        for (int there : computers[here]) {
            if (visited[there]) {
                continue;
            }
            ret += dfs(there);
        }
        return ret;
    }
}
