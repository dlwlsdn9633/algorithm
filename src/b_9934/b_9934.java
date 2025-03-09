package b_9934;

import java.io.*;
import java.util.ArrayList;

// 내가 풀었던 방식은 직접 Tree를 만들어서 푼 방식
public class b_9934 {
    private static int K;
    private static int[] values;
    private static boolean[] visited;
    private static ArrayList<Integer>[] tree;
    private static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setValues(br);
        Node root = CreateBinaryTree(0);
        dfs(root);
        for (int i = 0; i < tree.length; ++i) {
            for (Integer value : tree[i]) {
                bw.write(value + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    private static void setValues(BufferedReader br) throws IOException {
        K = Integer.parseInt(br.readLine());
        String conds[] = br.readLine().split(" ");
        values = new int[conds.length];
        visited = new boolean[conds.length + 1];
        tree = new ArrayList[K];
        for (int i = 0; i < conds.length; ++i) {
            values[i] = Integer.parseInt(conds[i]);
        }
        for (int i = 0; i < K; ++i) {
            tree[i] = new ArrayList<>();
        }
    }
    private static void dfs(Node node) {
        if (node.leftNode == null && node.rightNode == null) {
            node.visited = true;
            tree[node.depth].add(values[idx++]);
            return;
        }
        dfs(node.leftNode);
        tree[node.depth].add(values[idx++]);
        dfs(node.rightNode);
    }

    private static Node CreateBinaryTree(int depth) {
        if (depth == K - 1) {
            return new Node(depth);
        }
        Node node = new Node(depth);
        node.leftNode = CreateBinaryTree(depth + 1);
        node.rightNode = CreateBinaryTree(depth + 1);
        return node;
    }
    static class Node {
        Node leftNode;
        Node rightNode;
        int value;
        int depth;
        boolean visited;
        public Node(int depth) {
            this.depth = depth;
            this.visited = false;
        }
    }
}
