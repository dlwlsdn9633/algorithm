package b_17471;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class b_17471_2 {
    private static int N;
    private static int sum1 = 0;
    private static int sum2 = 0;
    private static int[] people;
    private static int[] map;
    private static boolean[] visit;
    private static int ret = Integer.MAX_VALUE;
    private static HashMap<Integer, ArrayList> adj = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setAdj(br);
        for (int bitNum = 0; bitNum < (1 << N); ++bitNum) {
            int start1 = -1;
            int start2 = -1;
            for (int bitIdx = 0; bitIdx < N; ++bitIdx) {
                if ((bitNum & (1 << bitIdx)) != 0) {
                    map[bitIdx] = 1;
                    start1 = bitIdx;
                } else {
                    map[bitIdx] = 2;
                    start2 = bitIdx;
                }
            }

            if (start1 != -1) {
                sum1 += people[start1];
                visit[start1] = true;
                dfs(start1, 1);
            }

            if (start2 != -1) {
                sum2 += people[start2];
                visit[start2] = true;
                dfs(start2, 2);
            }

            if (isAllVisit()) {
                int diff = Math.abs(sum1 - sum2);
                ret = Math.min(diff, ret);
            }

            allClear();
        }

        if (ret == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(ret));
        }

        bw.flush();
        bw.close();
    }
    private static void allClear() {
        sum1 = 0;
        sum2 = 0;
        Arrays.fill(map, 0);
        Arrays.fill(visit, false);
    }
    private static boolean isAllVisit() {
        for (int i = 0; i < visit.length; ++i) {
            if (visit[i] == false) {
                return false;
            }
        }
        return true;
    }
    private static void dfs(int here, int target) {
        for (int there : (ArrayList<Integer>)adj.get(here)) {
            if (visit[there]) {
                continue;
            }
            if (map[there] != target) {
                continue;
            }
            visit[there] = true;
            if (target == 1) {
                sum1 += people[there];
            } else {
                sum2 += people[there];
            }
            dfs(there, target);
        }
    }

    // idx가 1인것도 한번 하기
    private static void setAdj(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        map = new int[N];
        visit = new boolean[N];
        String[] peopleArr = br.readLine().split(" ");
        for (int node = 0; node < N; ++node) {
            people[node] = Integer.parseInt(peopleArr[node]);
        }
        for (int node = 0; node < N; ++node) {
            adj.put(node, new ArrayList());
            String[] paths = br.readLine().split(" ");
            for (int pathIdx = 1; pathIdx < paths.length; ++pathIdx) {
                adj.get(node).add(Integer.parseInt(paths[pathIdx]) - 1);
            }
        }
    }
}
