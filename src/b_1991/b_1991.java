package b_1991;

import java.io.*;
import java.util.StringTokenizer;
public class b_1991 {
    private static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        for (int i = 0; i < N; ++i) {
            tree[i] = new Node((char)0, null, null);
        }
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[root - 'A'].value = root;
            if (left != '.') {
                tree[root - 'A'].leftNode = tree[left - 'A'];
            }
            if (right != '.') {
                tree[root - 'A'].rightNode = tree[right - 'A'];
            }
        }

        pre(tree[0]);
        System.out.println();
        mid(tree[0]);
        System.out.println();
        post(tree[0]);

        bw.flush();
        bw.close();
        br.close();
    }
    private static void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        pre(node.leftNode);
        pre(node.rightNode);
    }
    private static void mid(Node node) {
        if (node == null) {
            return;
        }
        mid(node.leftNode);
        System.out.print(node.value);
        mid(node.rightNode);
    }

    private static void post(Node node) {
        if (node == null) {
            return;
        }
        post(node.leftNode);
        post(node.rightNode);
        System.out.print(node.value);
    }

    static class Node {
        char value;
        Node leftNode;
        Node rightNode;
        public Node(char value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
