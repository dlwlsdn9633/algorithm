package b_12869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_12869_a {
    private static int[][] dirs = {
        { 9, 3, 1 },
        { 9, 1, 3 },
        { 3, 9, 1 },
        { 3, 1, 9 },
        { 1, 3, 9 },
        { 1, 9, 3 }
    };
    private static int[][][] visited = new int[64][64][64];
    private static String[] scvs;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scvs = br.readLine().split(" ");
        SCV scv = getSCV();

        Queue<SCV> q = new LinkedList<>();
        q.add(scv);
        visited[scv.x][scv.y][scv.z] = 0;
        while (q.isEmpty() == false) {
            SCV currentScv = q.poll();
            if (visited[0][0][0] != 0) {
                break;
            }
            for (int i = 0; i < 6; ++i) {
                int nx = Math.max(0, currentScv.x - dirs[i][0]);
                int ny = Math.max(0, currentScv.y - dirs[i][1]);
                int nz = Math.max(0, currentScv.z - dirs[i][2]);
                if (visited[nx][ny][nz] != 0) {
                    continue; // 이미 방문한 경우
                }
                visited[nx][ny][nz] = visited[currentScv.x][currentScv.y][currentScv.z] + 1;
                q.add(new SCV(nx, ny, nz));
            }
        }
        System.out.println(visited[0][0][0]);
    }

    private static SCV getSCV() {
        SCV scv = new SCV();
        if (scvs.length == 3) {
            scv.x = Integer.valueOf(scvs[0]);
            scv.y = Integer.valueOf(scvs[1]);
            scv.z = Integer.valueOf(scvs[2]);
        } else if (scvs.length == 2) {
            scv.x = Integer.valueOf(scvs[0]);
            scv.y = Integer.valueOf(scvs[1]);
        } else {
            scv.x = Integer.valueOf(scvs[0]);
        }
        return scv;
    }


    static class SCV {
        int x;
        int y;
        int z;
        public SCV() {}
        public SCV(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
