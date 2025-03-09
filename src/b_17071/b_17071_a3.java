package b_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class b_17071_a3 {
    private static int max_n = 500000;
    private static boolean visited[][] = new boolean[2][max_n + 4];
    private static int N;
    private static int K;
    private static int turn = 1;
    private static boolean isCatch = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        // 만약 우연하게 같은 위치에 있었다면?
        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[0][N] = true;
        while (q.isEmpty() == false) {
            K += turn;
            if (K > max_n) {
                break;
            }
            // 짝수 시간 (또는 홀수 시간)에 동생이 K 지점에 도착했을 때, 이미 수빈이가 방문한 곳인가.
            if (visited[turn % 2][K] == true) {
                isCatch = true;
                break;
            }
            int qSize = q.size();
            for (int i = 0; i < qSize; ++i) {
                int currentSubinPos = q.poll();
                for (int nextSubinPos : List.of(currentSubinPos + 1, currentSubinPos - 1, 2 * currentSubinPos)) {
                    if (nextSubinPos < 0 || nextSubinPos > max_n) {
                        continue;
                    }
                    if (visited[turn % 2][nextSubinPos] == true) {
                        continue;
                    }

                    visited[turn % 2][nextSubinPos] = true;
                    if (nextSubinPos == K) {
                        isCatch = true;
                        break;
                    }
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
        if (isCatch) {
            System.out.println(turn);
        } else {
            System.out.println(-1);
        }
    }
}
