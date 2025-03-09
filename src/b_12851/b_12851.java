package b_12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_12851 {
    private static int dpCost[] = new int[100001];
    private static int dpNum[] = new int[100001];
    private static int N;
    private static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        Arrays.fill(dpCost, Integer.MAX_VALUE);
        Arrays.fill(dpNum, Integer.MAX_VALUE);

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(N, 0));
        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();
            if (currentPos.x < 0 || currentPos.x > 100000) {
                continue;
            }
            if (dpCost[currentPos.x] < currentPos.cost) {
                continue;
            } else if (dpCost[currentPos.x] == currentPos.cost) {
                ++dpNum[currentPos.x];
            } else {
                dpNum[currentPos.x] = 1;
                dpCost[currentPos.x] = currentPos.cost;
            }
            q.add(new Pos(currentPos.x + 1, currentPos.cost + 1));
            q.add(new Pos(currentPos.x - 1, currentPos.cost + 1));
            q.add(new Pos(currentPos.x * 2, currentPos.cost + 1));
        }
        System.out.println(dpCost[K]);
        System.out.println(dpNum[K]);
    }

    static class Pos {
        int x;
        int cost;
        public Pos(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
