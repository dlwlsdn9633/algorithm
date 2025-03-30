package b_17071;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class b_17071_2 {
    private static final int MAX_SIZE = 500_000;
    private static int N;
    private static int K;
    private static int turn = 1;
    private static Queue<Integer> q = new LinkedList<>();
    private static boolean[][] visit = new boolean[2][2 * MAX_SIZE + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        if (N == K) {
            System.out.println("0");
            return;
        }

        q.add(N);
        visit[0][N] = true;
        boolean isCatch = false;
        while (q.isEmpty() == false) {
            K += turn;
            if (K > MAX_SIZE) {
                break;
            }
            if (visit[turn % 2][K]) {
                isCatch = true;
                break;
            }
            int qSize = q.size();
            for (int qIdx = 0; qIdx < qSize; ++qIdx) {
                int subinPos = q.poll();
                for (int nextSubinPos : List.of(subinPos + 1, subinPos - 1, 2 * subinPos)) {
                    if (nextSubinPos < 0 || subinPos > MAX_SIZE) {
                        continue;
                    }
                    if (visit[turn % 2][nextSubinPos]) {
                        continue;
                    }
                    if (K == nextSubinPos) {
                        isCatch = true;
                        break;
                    }
                    visit[turn % 2][nextSubinPos] = true;
                    q.add(nextSubinPos);
                }
                if (isCatch) {
                    break;
                }
            }
            if (isCatch) {
                break;
            }
            ++turn;
        }
        if (isCatch == false) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(turn));
        }
        bw.flush();
        bw.close();
    }
}
