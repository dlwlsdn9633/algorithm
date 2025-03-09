package b_1446;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class b_1446 {
    private static int cost = Integer.MAX_VALUE;
    private static int shortcutsNumber;
    private static int targetPosition;
    private static int[][] shortcuts;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        shortcutsNumber = scanner.nextInt();
        targetPosition = scanner.nextInt();
        shortcuts = new int[shortcutsNumber][3];

        for (int i = 0; i < shortcutsNumber; ++i) {
            for (int j = 0; j < 3; ++j) {
                shortcuts[i][j] = scanner.nextInt();
            }
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));

        while (queue.isEmpty() == false) {
            Node currentNode = queue.poll();

            if (currentNode.currentPosition > targetPosition) {
                continue;
            } else if (currentNode.currentPosition == targetPosition) {
                if (cost > currentNode.currentCost) {
                    cost = currentNode.currentCost;
                }
                continue;
            } else {
                for (int i = 0; i < shortcuts.length; ++i) {
                    if (currentNode.currentPosition == shortcuts[i][0]) {
                        Node anotherNode = new Node(shortcuts[i][1], currentNode.currentCost + shortcuts[i][2]);
                        queue.add(anotherNode);
                    }
                }
                currentNode.currentPosition += 1;
                currentNode.currentCost += 1;
                queue.add(currentNode);
            }
        }

        System.out.println(cost);
    }


    static class Node {
        public int currentPosition;
        public int currentCost;
        public Node(int currentPosition, int currentCost) {
            this.currentPosition = currentPosition;
            this.currentCost = currentCost;
        }
    }
}
