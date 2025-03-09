package b_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class b_17071_a2 {
    private static int max_n = 500000;
    private static boolean[][] visited = new boolean[2][max_n + 4];
    private static int N;
    private static int K;
    private static int turn = 1;
    private static boolean isCatch = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");

        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        if (N == K) {
            System.out.println(0);
            return;
        }

        visited[0][N] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(N); // q는 수빈이의 위치를 나타낸다.

        while (q.isEmpty() == false) {
            K += turn;
            if (K > max_n) {
                // 동생이 이미 경계값 너머 도망갔다면?
                break;
            }
            if (visited[(turn) % 2][K] == true) {
                // 이미 수빈이가 방문한 위치라면 왔다리 갔다리로 잡을 수 있다.
                isCatch = true;
                break;
            }
            int qSize = q.size();
            for (int i = 0; i < qSize; ++i) {
                int currentSubinPos = q.poll();
                for (int nextSubinPos : List.of(currentSubinPos + 1, currentSubinPos - 1, 2 * currentSubinPos)) {
                    if (nextSubinPos < 0 || nextSubinPos > max_n) {
                        // 다음 subin이의 위치가 경계값을 넘어갔다면?
                        continue;
                    }
                    if (visited[turn % 2][nextSubinPos] == true) {
                        // 현재 턴에서 다음 수빈이의 위치에 이미 방문했다면?
                        continue; // 왜? -> 이미 계속 방문할 수 있는 위치가 되기 떄문이다.
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
