package b_1916;

import java.io.*;
import java.util.*;

public class b_1916 {
    private static int[] dp;
    private static HashMap<Integer, ArrayList<Pos>> costMap = new HashMap<>();
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int n = 1; n <= N; ++n) {
            costMap.put(n, new ArrayList<>());
        }

        for (int m = 0; m < M; ++m) {
            String[] conds = br.readLine().split(" ");
            costMap.get(Integer.parseInt(conds[0])).add(new Pos(Integer.parseInt(conds[1]), Integer.parseInt(conds[2])));
        }

        String[] conds = br.readLine().split(" ");
        int startPos = Integer.parseInt(conds[0]);
        int endPos = Integer.parseInt(conds[1]);

        dp[startPos] = 0;
        q.add(startPos);
        while (q.isEmpty() == false) {
            int here = q.poll();
            for (Pos there : costMap.get(here)) {
                if (dp[here] + there.cost > dp[there.pos]) {
                    continue;
                }
                dp[there.pos] = dp[here] + there.cost;
                q.add(there.pos);
            }
        }
        bw.write(String.valueOf(dp[endPos]));
        bw.flush();
        bw.close();
    }

    static class Pos {
        int pos;
        int cost;
        public Pos(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }
    }
}
