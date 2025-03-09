package b_1068;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b_1068 {
    private static Map<Integer, ArrayList<Integer>> tree = new HashMap<>();
    private static int deleteNode;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodesNumber = scanner.nextInt();
        scanner.nextLine();

        int rootNode = 0;
        String parentNodes[] = scanner.nextLine().split(" ");
        for (int node = 0; node < nodesNumber; ++node) {
            if (tree.get(node) == null) {
                tree.put(node, new ArrayList<>());
            }
            int parentNode = Integer.valueOf(parentNodes[node]);
            if (parentNode == -1) {
                rootNode = node;
                continue;
            }
            ArrayList<Integer> childNodes = null;
            childNodes = (tree.get(parentNode) == null) ? new ArrayList<>() : tree.get(parentNode);
            childNodes.add(node);
            tree.put(parentNode, childNodes);
        }
        deleteNode = scanner.nextInt();
        scanner.nextLine();

        int sum = traversal(rootNode);
        System.out.println(sum);
    }
    private static int traversal(int node) {
        if (node == deleteNode) {
            return 0;
        }
        int childNodeSize = 0;
        for (Integer childNode : tree.get(node)) {
            childNodeSize += traversal(childNode);
        }
        // 나한테 ChildNode가 없으면, 내가 ChildNode야! -> 1반환한다.
        return (childNodeSize == 0) ? 1 : childNodeSize;
    }
}
