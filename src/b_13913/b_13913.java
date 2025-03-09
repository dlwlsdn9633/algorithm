package b_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_13913 {
    private static int dpPrev[] = new int[100001];
    private static int dpCost[] = new int[100001];
    private static int N;
    private static int K;
    private static Queue<Pos> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        Arrays.fill(dpPrev, Integer.MAX_VALUE);
        Arrays.fill(dpCost, Integer.MAX_VALUE);
        q.add(new Pos(N, 0, -1));

        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();
            if (currentPos.x < 0 || currentPos.x > 100000) {
                continue;
            }
            if (currentPos.cost >= dpCost[currentPos.x]) {
                continue;
            }
            dpCost[currentPos.x] = currentPos.cost;
            dpPrev[currentPos.x] = currentPos.prev;
            q.add(new Pos(currentPos.x + 1, currentPos.cost + 1, currentPos.x));
            q.add(new Pos(currentPos.x - 1, currentPos.cost + 1, currentPos.x));
            q.add(new Pos(currentPos.x * 2, currentPos.cost + 1, currentPos.x));
        }

        ArrayList<Integer> tracking = new ArrayList<>();
        tracking.add(K);
        int trackingIdx = K;
        while (dpPrev[trackingIdx] != -1) {
            tracking.add(dpPrev[trackingIdx]);
            trackingIdx = dpPrev[trackingIdx];
        }
        System.out.println(dpCost[K]);
        for (int i = tracking.size() - 1; i >= 0; --i) {
            System.out.print(tracking.get(i) + " ");
        }
    }
    static class Pos {
        int x;
        int prev;
        int cost;
        public Pos(int x, int cost, int prev) {
            this.x = x;
            this.cost = cost;
            this.prev = prev;
        }
    }
}
