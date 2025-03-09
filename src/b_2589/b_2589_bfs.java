package b_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_2589_bfs {
    private static int H;
    private static int W;
    private static char map[][];
    private static int visited[][];
    private static ArrayList<Pos> landList = new ArrayList<>();
    private static int dirs[][] = {
            { +0, +1 },
            { +0, -1 },
            { +1, +0 },
            { -1, +0 }
    };
    private static int maxVal = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");
        H = Integer.parseInt(conds[0]);
        W = Integer.parseInt(conds[1]);
        setMap(br);
        for (int i = 0; i < landList.size(); ++i) {
            for (int j = 0; j < H; ++j) {
                Arrays.fill(visited[j], 0);
            }
            bfs(landList.get(i));
        }
        System.out.println(maxVal - 1);
    }

    private static void bfs(Pos pos) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(pos.y, pos.x));
        visited[pos.y][pos.x] = 1;

        while (q.isEmpty() == false) {
            Pos currentPos = q.poll();

            for (int i = 0; i < 4; ++i) {
                int ny = currentPos.y + dirs[i][0];
                int nx = currentPos.x + dirs[i][1];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W) {
                    continue;
                }
                if (visited[ny][nx] != 0) {
                    continue;
                }
                if (map[ny][nx] == 'W') {
                    continue;
                }
                visited[ny][nx] = visited[currentPos.y][currentPos.x] + 1;
                maxVal = Math.max(visited[ny][nx], maxVal);
                q.add(new Pos(ny, nx));
            }
        }
    }

    private static void setMap(BufferedReader br) throws IOException {
        map = new char[H][W];
        visited = new int[H][W];
        for (int y = 0; y < H; ++y) {
            String row = br.readLine();
            for (int x = 0; x < row.length(); ++x) {
                map[y][x] = row.charAt(x);
                if (map[y][x] == 'L') {
                    landList.add(new Pos(y, x));
                }
            }
        }
    }
    static class Pos {
        int y;
        int x;
        int depth;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
