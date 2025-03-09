package b_14497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Queue를 2개 쓰는 방법
public class b_14497_a {
    private static char map[][] = new char[301][301];
    private static int visited[][] = new int[301][301];
    private static int dirs[][] = {
            { +0, +1 },
            { +0, -1 },
            { +1, +0 },
            { -1, +0 }
    };
    private static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        int N = Integer.parseInt(conds[0]);
        int M = Integer.parseInt(conds[1]);

        String[] poses = br.readLine().split(" ");
        int y1 = Integer.parseInt(poses[0]) - 1;
        int x1 = Integer.parseInt(poses[1]) - 1;
        int y2 = Integer.parseInt(poses[2]) - 1;
        int x2 = Integer.parseInt(poses[3]) - 1;
        for (int y = 0; y < N; ++y) {
            map[y] = br.readLine().toCharArray();
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1000 * y1 + x1); // 나누기와 모듈러 연산으로 y와 x를 뽑아낼 수 있음

        int cnt = 0;
        while (map[y2][x2] != '0') {
            ++cnt;
            Queue<Integer> temp = new LinkedList<>(); // next 탐색할 노드들을 담는다.
            while (q.isEmpty() == false) {
                int y = q.peek() / 1000;
                int x = q.peek() % 1000;
                q.poll();
                for (int i = 0; i < 4; ++i) {
                    int ny = y + dirs[i][0];
                    int nx = x + dirs[i][1];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                        continue;
                    }
                    if (visited[ny][nx] != 0) {
                        continue;
                    }
                    visited[ny][nx] = cnt;
                    if (map[ny][nx] != '0') {
                        map[ny][nx] = '0';
                        temp.add(1000 * ny + nx);
                    } else {
                        q.add(1000 * ny + nx);
                    }
                }
            }
            q = temp;
        }
        System.out.println(visited[y2][x2]);
    }
}
