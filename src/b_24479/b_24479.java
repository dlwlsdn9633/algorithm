package b_24479;

import java.io.*;
import java.util.*;

public class b_24479 {
    private static int N;
    private static int M;
    private static int R;
    private static boolean[] visited;
    private static int visitedNumIdx = 1;
    private static int[] visitedNum;
    private static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int n = 1; n <= N; ++n) {
            map.put(n, new ArrayList<>());
        }

        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
        }
        for (int n = 1; n <= N; ++n) {
            map.get(n).sort((e1, e2) -> e1 - e2);
        }
        visited = new boolean[N + 1];
        visitedNum = new int[N + 1];
        dfs(1, 1);
        for (int i = 1; i <= N; ++i) {
            System.out.println(visitedNum[i]);
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int node, int depth) {
        visited[node] = true;
        visitedNum[visitedNumIdx++] = node;
        for (int next : map.get(node)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}
