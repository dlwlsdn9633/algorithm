package b_10709;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class b_10709 {
    private static Queue<Cloud> q = new ArrayDeque<>();
    private static int costMap[][];
    private static int H;
    private static int W;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");

        H = Integer.valueOf(conds[0]);
        W = Integer.valueOf(conds[1]);

        costMap = new int[H + 1][W + 1];
        setMap(scanner);

        while (q.isEmpty() == false) {
            Cloud currentCloud = q.poll();
            if (currentCloud.x > W) {
                continue;
            }

            if (costMap[currentCloud.y][currentCloud.x] == -1) {
                costMap[currentCloud.y][currentCloud.x] = currentCloud.cost;
            }

            currentCloud.cost = currentCloud.cost + 1;
            currentCloud.x = currentCloud.x + 1;
            q.add(currentCloud);
        }

        printMap();
    }

    private static void setMap(Scanner scanner) {
        for (int i = 1; i <= H; ++i) {
            String row = scanner.nextLine();
            for (int j = 1; j <= row.length(); ++j) {
                costMap[i][j] = -1;
                if (row.charAt(j - 1) == 'c') {
                    q.add(new Cloud(i, j));
                }
            }
        }
    }

    private static void printMap() {
        for (int i = 1; i <= H; ++i) {
            for (int j = 1; j <= W; ++j) {
                System.out.print(costMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Cloud {
        public int y;
        public int x;
        public int cost;
        public Cloud(int y, int x) {
            this.y = y;
            this.x = x;
            this.cost = 0;
        }
    }
}
