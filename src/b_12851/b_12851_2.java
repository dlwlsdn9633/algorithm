package b_12851;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class b_12851_2 {
    private static final int MAX_LEN = 100_000;
    private static Queue<Pos> q = new LinkedList<>();
    private static int[] dpMethods = new int[MAX_LEN + 1];
    private static int[] dpTurns = new int[MAX_LEN + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int N = Integer.parseInt(conds[0]);
        int K = Integer.parseInt(conds[1]);
        Arrays.fill(dpMethods, Integer.MAX_VALUE);
        Arrays.fill(dpTurns, Integer.MAX_VALUE);

        dpMethods[N] = 1;
        dpTurns[N] = 0;
        q.add(new Pos(N, 0));
        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();
            for (int nextPos : List.of(currentPos.pos + 1, currentPos.pos - 1, currentPos.pos * 2)) {
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
        int pos;
        int turn;
        public Pos(int pos, int turn) {
            this.pos = pos;
            this.turn = turn;
        }
    }
}
