package b_1068;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class b_1068_2 {
    private static int N;
    private static int rootNode;
    private static int deleteNode;
    private static HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setTree(br);
        int sum = dfs(rootNode);
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
    private static int dfs(int node) {
        if (node == deleteNode) {
            return 0;
        }
        int sum = 0;
        for (int childNode : tree.get(node)) {
            sum += dfs(childNode);
        }
        return (sum == 0 ? 1 : sum);
    }

    private static void setTree(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] parentNodes = br.readLine().split(" ");
        for (int node = 0; node < N; ++node) {
            tree.put(node, new ArrayList<>());
        }
        for (int node = 0; node < N; ++node) {
            if (Integer.parseInt(parentNodes[node]) == -1) {
                rootNode = node;
            } else {
                tree.get(Integer.parseInt(parentNodes[node])).add(node);
            }
        }
        deleteNode = Integer.parseInt(br.readLine());
    }
}
