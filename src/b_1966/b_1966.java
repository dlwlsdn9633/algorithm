package b_1966;


import java.io.*;
import java.util.*;

public class b_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            test(br, bw);
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static void test(BufferedReader br, BufferedWriter bw) throws IOException {
        int cnt = 0;
        Deque<Node> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        Arrays.fill(dp, 0);
        st = new StringTokenizer(br.readLine());
        for (int node = 0; node < N; ++node) {
            queue.add(new Node(node, Integer.parseInt(st.nextToken())));
        }
        while (!queue.isEmpty()) {
            Node poppedNode = queue.poll();
            if (isExisted(queue, poppedNode)) {
                queue.add(poppedNode);
            } else {
                dp[poppedNode.node] = ++cnt;
            }
        }
        bw.write(String.valueOf(dp[M]));
        bw.newLine();
    }
    private static boolean isExisted(Deque<Node> q, Node poppedNode) {
        if (q.isEmpty()) {
            return false;
        }
        for (Node node : q) {
            if (poppedNode.rank < node.rank) {
                return true;
            }
        }
        return false;
    }
    static class Node {
        int node;
        int rank;
        public Node(int node, int rank) {
            this.node = node;
            this.rank = rank;
        }
    }
}
