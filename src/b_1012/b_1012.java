package b_1012;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b_1012 {

    private static int answer = 0;
    private static int M = 0;
    private static int N = 0;
    private static int K = 0;
    private static Map<Pos, Boolean> visited = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < T; ++t) {
            String[] conds = scanner.nextLine().split(" ");

            M = Integer.valueOf(conds[0]);
            N = Integer.valueOf(conds[1]);
            K = Integer.valueOf(conds[2]);

            for (int k = 0; k < K; ++k) {
                String[] pos = scanner.nextLine().split(" ");
                Pos currentPos = new Pos(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]));
                visited.put(currentPos, false);
            }


            for (Map.Entry<Pos, Boolean> entry : visited.entrySet()) {
                if (entry.getValue() == false) {
                    dfs(entry.getKey().x , entry.getKey().y);
                    ++answer;
                }
            }

            System.out.println(answer);
            allClear();
        }
    }

    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x > M || y > N) {
            return;
        }

        if (findPos(x, y) == false) {
            return;
        }

        if (isVisited(x, y) == true) {
            return;
        }

        setVisited(x, y);

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }

    private static boolean findPos(int x, int y) {
        for (Map.Entry<Pos, Boolean> entry : visited.entrySet()) {
            if (entry.getKey().x == x && entry.getKey().y == y) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVisited(int x, int y) {
        for (Map.Entry<Pos, Boolean> entry : visited.entrySet()) {
            if (entry.getKey().x == x && entry.getKey().y == y) {
                return entry.getValue();
            }
        }
        return false;
    }

    private static void setVisited(int x, int y) {
        for (Map.Entry<Pos, Boolean> entry : visited.entrySet()) {
            if (entry.getKey().x == x && entry.getKey().y == y) {
                entry.setValue(true);
            }
        }
    }

    private static void allClear() {
        N = 0;
        M = 0;
        K = 0;
        visited.clear();
        answer = 0;
    }

    static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(x: " + x + ", y: " + y + ")";
        }
    }
}