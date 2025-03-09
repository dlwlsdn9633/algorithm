package b_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 실행 시간이 매우 오래 걸린다. -> 결국 풀지 못함
public class b_17071 {
    private static int N;
    private static int K;
    private static int answer = Integer.MAX_VALUE;
    private static int dpCost[] = new int[500001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        Arrays.fill(dpCost, Integer.MAX_VALUE);
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(N, 0));
        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();
            if (currentPos.x < 0 || currentPos.x > 500000) {
                continue;
            }
            if (dpCost[currentPos.x] <= currentPos.cost) {
                continue;
            }
            dpCost[currentPos.x] = currentPos.cost;

            int brotherPos = K + ((currentPos.cost * (currentPos.cost + 1)) / 2);
            if (currentPos.x == brotherPos) {
                answer = Math.min(answer, dpCost[currentPos.x]);
                continue;
            }
            q.add(new Pos(currentPos.x + 1, currentPos.cost + 1));
            q.add(new Pos(currentPos.x - 1, currentPos.cost - 1));
            q.add(new Pos(currentPos.x * 2, currentPos.cost + 1));
        }
        System.out.println(answer);
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
