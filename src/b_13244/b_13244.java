package b_13244;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class b_13244 {
    private static int T;
    private static int N; // the number of nodes in the graph.
    private static int M; // the number of edges int the graph.
    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static boolean[] visited;
    private static boolean firstCond = true;
    private static boolean secondCond = true;
    private static boolean thirdCond = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            testcase(br, bw);
        }
        bw.flush();
        bw.close();
    }

    private static void testcase(BufferedReader br, BufferedWriter bw) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int m = 0; m < M; ++m) {
            String[] conds = br.readLine().split(" ");
            int node1 = Integer.parseInt(conds[0]);
            int node2 = Integer.parseInt(conds[1]);
            if (graph.get(node1) == null) {
                graph.put(node1, new ArrayList<>());
            }
            graph.get(node1).add(node2);
            if (graph.get(node2) == null) {
                graph.put(node2, new ArrayList<>());
            }
            graph.get(node2).add(node1);
        }

        int startNode = (int)(graph.keySet().toArray()[0]);
        visited[startNode] = true;
        dfs(startNode);
        firstCond = allVisited();

        if (N - 1 < M) {
            secondCond = false;
            thirdCond = false;
        }

        if (firstCond && secondCond && thirdCond) {
            bw.write("tree");
            bw.write("\n");
        } else {
            bw.write("graph");
            bw.write("\n");
        }
        allClear();
    }
    private static boolean allVisited() {
        boolean firstVisit = visited[1];
        for (int i = 1; i < visited.length; ++i) {
            if (firstVisit != visited[i]) {
                return false;
            }
        }
        return true;
    }
    private static void dfs(int here) {
        for (int node : graph.get(here)) {
            if (visited[node] == true) {
                continue;
            }

            visited[node] = true;
            dfs(node);
        }
    }
    private static void allClear() {
        N = 0;
        M = 0;
        firstCond = true;
        secondCond = true;
        thirdCond = true;
        for (Integer key : graph.keySet()) {
            graph.get(key).clear();
        }
        graph.clear();
    }
}
