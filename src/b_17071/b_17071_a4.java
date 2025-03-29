package b_17071;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class b_17071_a4 {
    private static int N;
    private static int K;
    private final static int MAX_N = 500001;
    private static int turn = 1;
    private static Queue<Integer> subinPositionQ = new LinkedList<>();
    private static boolean[][] visit = new boolean[2][MAX_N];
    private static boolean isCatch = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);
        // 만약 turn을 시작하기 전 같은 위치에 있다면
        if (N == K) {
            System.out.print(0);
            return;
        }

        subinPositionQ.add(N);
        visit[0][N] = true;
        while (subinPositionQ.isEmpty() == false) {
            K += turn;
            if (K >= MAX_N) {
                break;
            }
            if (visit[turn % 2][K] == true) {
                // 이미 수빈이 방문한 곳이라면
                isCatch = true;
                break;
            }
            int qSize = subinPositionQ.size();
            for (int qIdx = 0; qIdx < qSize; ++qIdx) {
                int currentSubinPos = subinPositionQ.poll();
                for (int nextSubinPos : List.of(currentSubinPos + 1, currentSubinPos - 1, 2 * currentSubinPos)) {
                    if (nextSubinPos < 0 || nextSubinPos >= MAX_N) {
                        continue;
                    }
                    if (visit[turn % 2][nextSubinPos]) {
                        continue;
                    }
                    visit[turn % 2][nextSubinPos] = true;
                    if (nextSubinPos == K) {
                        isCatch = true;
                        break;
                    }
                    subinPositionQ.add(nextSubinPos);
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
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(turn));
        }

        bw.flush();
        bw.close();
    }
}
