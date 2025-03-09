package b_1325;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_1325_2_bfs {
    private static int N;
    private static int M;
    private static ArrayList<ArrayList<Integer>> computers;
    private static int dp[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);

        dp = new int[N + 1];
        computers = new ArrayList<ArrayList<Integer>>();
        for (int n = 0; n <= N; ++n) {
            computers.add(new ArrayList<>());
        }

        for (int m = 0; m < M; ++m) {
            String[] poses = br.readLine().split(" ");
            int A = Integer.parseInt(poses[0]);
            int B = Integer.parseInt(poses[1]);
            computers.get(A).add(B);
        }

        for (int com = 1; com <= N; ++com) {
            visited = new boolean[N + 1];
            bfs(com);
        }

        int maxValue = Arrays.stream(dp).max().getAsInt();
        for (int com = 1; com <= N; ++com) {
            if (maxValue == dp[com]) {
                bw.write(com + " ");
            }
        }

        bw.flush();
        bw.close();

    }
    private static void bfs(int startCom) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startCom);
        visited[startCom] = true;
        while (q.isEmpty() == false) {
            int currentCom = q.poll();
            for (int child : computers.get(currentCom)) {
                if (visited[child]) {
                    continue;
                }
                visited[child] = true;
                q.add(child);
                ++dp[child];
            }
        }
    }
}
