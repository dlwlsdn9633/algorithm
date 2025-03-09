package b_1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class b_1325_bfs {
    private static int N;
    private static int M;
    private static ArrayList<Integer>[] adj;
    private static boolean visited[];
    private static int dp[];
    private static int mx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int com = 1; com <= N; ++com) {
            adj[com] = new ArrayList<Integer>();
        }
        visited = new boolean[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, 0);
        Arrays.fill(visited, false);

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[B].add(A);
        }

        for (int com = 1; com <= N; ++com) {
            Arrays.fill(visited, false);
            bfs(com);
        }

        for (int com = 1; com <= N; ++com) {
            if (mx == dp[com]) {
                System.out.print(com + " ");
            }
        }
    }
    private static void bfs(int here) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(here, 1));
        while (q.isEmpty() == false) {
            Node currentNode = q.poll();
            if (visited[currentNode.com] == true) {
                continue;
            }
            if (adj[currentNode.com].size() == 0) {
                // 더 이상 해킹할 컴퓨터가 없을 때
                dp[here] = Math.max(dp[here], currentNode.cost);
                mx = Math.max(dp[here], mx);
                continue;
            }
            for (int there : adj[currentNode.com]) {
                q.add(new Node(there, currentNode.cost + 1));
            }
        }
    }
    static class Node {
        int com;
        int cost;
        public Node(int com, int cost) {
            this.com = com;
            this.cost = cost;
        }
    }
}
