package b_24445;

import java.io.*;
import java.util.*;

public class b_24445 {
    private static int N;
    private static int M;
    private static int R;
    private static Map<Integer, List<Integer>> adj = new HashMap<>();
    private static boolean[] visited;
    private static int cnt;
    private static int[] sequences;
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        q.add(R);
        visited[R] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            sequences[node] = ++cnt;
            adj.get(node).sort((node1, node2) -> node2 - node1);
            for (int next : adj.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        for (int node = 1; node <= N; ++node) {
            bw.write(String.valueOf(sequences[node]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for (int node = 1; node <= N; ++node) {
            adj.put(node, new ArrayList<>());
        }
        visited = new boolean[N + 1];
        sequences = new int[N + 1];
        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
    }
}
