package b_24480;

import java.io.*;
import java.util.*;

public class b_24480 {
    private static int N;
    private static int M;
    private static int R;
    private static int cnt;
    private static int[] sequences;
    private static boolean[] visited;
    private static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        dfs(R);
        for (int node = 1; node <= N; ++node) {
            bw.write(String.valueOf(sequences[node]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int node) {
        visited[node] = true;
        sequences[node] = ++cnt;
        map.get(node).sort((node1, node2) -> node2 - node1);
        for (int next : map.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        sequences = new int[N + 1];

        for (int node = 1; node <= N; ++node) {
            map.put(node, new ArrayList<>());
        }

        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
            map.get(end).add(start);
        }
    }
}
