package b_12851;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class b_12851_3 {
    private static final int MAX_LEN = 100_000;
    private static int N;
    private static int K;
    private static int[] dpTurns = new int[MAX_LEN + 1];
    private static int[] dpMethods = new int[MAX_LEN + 1];
    private static Queue<Pos> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        Arrays.fill(dpTurns, Integer.MAX_VALUE);
        Arrays.fill(dpMethods, Integer.MAX_VALUE);

        dpMethods[N] = 1;
        dpTurns[N] = 0;
        q.add(new Pos(N, 0));
        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();
            for (int nextPos : List.of(currentPos.x + 1, currentPos.x - 1, currentPos.x * 2)) {
                if (nextPos < 0 || nextPos > MAX_LEN) {
                    continue;
                }
                if (dpTurns[nextPos] == currentPos.turn + 1) {
                    ++dpMethods[nextPos];
                } else if (dpTurns[nextPos] > currentPos.turn + 1) {
                    dpMethods[nextPos] = 1;
                    dpTurns[nextPos] = currentPos.turn + 1;
                } else {
                    continue;
                }
                q.add(new Pos(nextPos, currentPos.turn + 1));
            }
        }

        bw.write(String.valueOf(dpTurns[K]));
        bw.write("\n");
        bw.write(String.valueOf(dpMethods[K]));

        bw.flush();
        bw.close();
    }

    static class Pos {
        int x;
        int turn;
        public Pos(int x, int turn) {
            this.x = x;
            this.turn = turn;
        }
    }
}
