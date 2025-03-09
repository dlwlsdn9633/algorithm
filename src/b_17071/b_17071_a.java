package b_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_17071_a {
    private static int max_n = 500000; // 갈 수 있는 최대 위치
    private static int[][] visited = new int[2][max_n + 4]; // 여기서 2개를 넣은 이유는?
    private static int a; // 수빈이의 위치
    private static int b; // 동생의 위치
    private static boolean ok = false;
    private static int turn = 1; // turn은 1부터 시작
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        a = Integer.parseInt(conds[0]);
        b = Integer.parseInt(conds[1]);

        // 만약에 수빈이와 동생이 같은 곳에 있다면?
        if (a == b) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        visited[0][a] = 1; // 0은 turn을 의미하는 것인가? -> turn이 0이다.
        q.add(a);
        while (q.isEmpty() == false) {
            b += turn; // b는 동생의 위치

            // 만약 동생이 50000 위치를 넘었다면
            if (b > max_n) {
                break;
            }

            // 홀수 (또는 짝수)인 시간에 b에 누군가 방문을 했는가?
            if (visited[turn % 2][b] != 0) {
                ok = true;
                break;
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; ++i) {
                int x = q.poll(); // 현재 x는 나의 위치

                for (int nx : Arrays.asList(x + 1, x - 1, 2 * x)) {
                    // 반복은 내부 코드
                    // 다음에 이동할 곳이 경계값을 넘어가는가? 그리고 이미 방문을 했던 곳인가?를 체크한다.
                    if (nx < 0 || nx > max_n || visited[turn % 2][nx] != 0) {
                        continue;
                    }

                    visited[turn % 2][nx] = visited[(turn + 1) % 2][x];
                    if (nx == b) {
                        // 만약 다음에 이동한 곳이 동생이 있는 곳이라면? => 오 나이스! 잡았다!
                        ok = true;
                        break;
                    }
                    // 만약 아니라면 그냥 다음 곳으로 이동한다.
                    q.add(nx);
                }
                if (ok) {
                    break;
                }
            }
            if (ok) {
                break;
            }
            ++turn;
        }
        if (ok) {
            System.out.println(turn);
        } else {
            System.out.println(-1);
        }
    }
}
