package b_12869;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_12869_3 {
    private static int[][] dirs = {
            { 9, 3, 1 },
            { 9, 1, 3 },
            { 3, 1, 9 },
            { 3, 9, 1 },
            { 1, 3, 9 },
            { 1, 9, 3 }
    };
    private static int[][][] visit = new int[64][64][64];
    private static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] scvs = new int[3];
        Arrays.fill(scvs, 0);
        String[] conds = br.readLine().split(" ");
        for (int n = 0; n < N; ++n) {
            scvs[n] = Integer.parseInt(conds[n]);
        }

        SCV scvSet = new SCV(scvs[0], scvs[1], scvs[2]);
        Queue<SCV> q = new LinkedList<>();
        q.add(scvSet);
        visit[scvs[0]][scvs[1]][scvs[2]] = 0;

        while (q.isEmpty() == false) {
            SCV currentScvSet = q.poll();
            if (currentScvSet.scv1 == 0 && currentScvSet.scv2 == 0 && currentScvSet.scv3 == 0) {
                ret = visit[currentScvSet.scv1][currentScvSet.scv2][currentScvSet.scv3];
                break;
            }
            for (int dirIdx = 0; dirIdx < 6; ++dirIdx) {
                int nx = Math.max(currentScvSet.scv1 - dirs[dirIdx][0], 0);
                int ny = Math.max(currentScvSet.scv2 - dirs[dirIdx][1], 0);
                int nz = Math.max(currentScvSet.scv3 - dirs[dirIdx][2], 0);
                if (visit[nx][ny][nz] != 0) {
                    continue;
                }
                visit[nx][ny][nz] = visit[currentScvSet.scv1][currentScvSet.scv2][currentScvSet.scv3] + 1;
                q.add(new SCV(nx, ny, nz));
            }
        }

        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
    static class SCV {
        int scv1;
        int scv2;
        int scv3;
        public SCV(int scv1, int scv2, int scv3) {
            this.scv1 = scv1;
            this.scv2 = scv2;
            this.scv3 = scv3;
        }
    }
}
