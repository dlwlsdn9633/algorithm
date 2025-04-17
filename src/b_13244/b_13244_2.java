package b_13244;

import java.io.*;
import java.util.*;
public class b_13244_2 {
    private static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            test(br, bw);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void test(BufferedReader br, BufferedWriter bw) throws IOException {
        int nodes = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[nodes + 1];
        Arrays.fill(visited, false);
        Map<Integer, ArrayList<Integer>> treeMap = new HashMap<>();

        for (int node = 0; node <= nodes; ++node) {
            treeMap.put(node, new ArrayList<>());
        }

        for (int lineIdx = 0; lineIdx < lines; ++lineIdx) {
            String[] conds = br.readLine().split(" ");
            int fromNode = Integer.parseInt(conds[0]);
            int toNode = Integer.parseInt(conds[1]);
            treeMap.get(fromNode).add(toNode);
            treeMap.get(toNode).add(fromNode);
        }

        if (lines != nodes - 1) {
            bw.write("graph");
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        while (q.isEmpty() == false) {
            int currentPos = q.poll();
            for (int nextPos : treeMap.get(currentPos)) {
                if (visited[nextPos]) {
                    continue;
                }
                visited[nextPos] = true;
                q.add(nextPos);
            }
        }

        if (checkAllVisit(visited)) {
            bw.write("tree");
        } else {
            bw.write("graph");
        }
    }

    private static boolean checkAllVisit(boolean[] visit) {
        for (int i = 1; i < visit.length; ++i) {
            if (visit[i] == false) {
                return false;
            }
        }
        return true;
    }
}
