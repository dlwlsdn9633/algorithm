package b_17471;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class b_17471 {
    private static int N; // 구역의 수
    private static int[] people;
    private static HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    private static ArrayList<Integer> A = new ArrayList<>();
    private static ArrayList<Integer> B = new ArrayList<>();
    private static boolean[] visited;
    private static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setPeople(br);
        setAdj(br);

        for (int i = 0; i < (1 << N); ++i) {
            for (int j = 0; j < N; ++j) {
                if ((i & (1 << j)) != 0) {
                    A.add(Integer.valueOf(j + 1));
                }
                if ((i & (1 << j)) == 0) {
                    B.add(Integer.valueOf(j + 1));
                }
            }
            setVisited();
            setMinValue();
            clearAll();
        }
        if (minValue == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(minValue));
        }
        bw.flush();
        bw.close();
    }
    private static void setPeople(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        visited = new boolean[N + 1];
        String[] conds = br.readLine().split(" ");
        for (int i = 1; i <= N; ++i) {
            people[i] = Integer.parseInt(conds[i - 1]);
        }
    }
    private static void setAdj(BufferedReader br) throws IOException {
        for (int city = 1; city <= N; ++city) {
            if (adj.get(city) == null) {
                adj.put(city, new ArrayList<>());
            }
            String conds[] = br.readLine().split(" ");
            for (int i = 1; i < conds.length; ++i) {
                adj.get(city).add(Integer.valueOf(conds[i]));
            }
        }
    }
    private static void setMinValue() {
        if (isAllConnected()) {
            int APeopleSum = 0;
            int BPeopleSum = 0;
            for (int idx : A) {
                APeopleSum += people[idx];
            }
            for (int idx : B) {
                BPeopleSum += people[idx];
            }
            int diff = Math.abs(APeopleSum - BPeopleSum);
            minValue = Math.min(diff, minValue);
        }
    }
    private static void setVisited() {
        if (A.size() != 0) {
            visited[A.get(0)] = true;
            dfs(A.get(0), 1, A);
        }

        if (B.size() != 0) {
            visited[B.get(0)] = true;
            dfs(B.get(0), 1, B);
        }
    }
    private static void dfs(int here, int depth, ArrayList<Integer> path) {
        if (depth == path.size()) {
            return;
        }
        for (int there : path) {
            if (visited[there]) {
                continue;
            }
            if (path.contains(there) == false) {
                continue;
            }
            if (adj.get(here).contains(there) == false) {
                continue;
            }
            visited[there] = true;
            dfs(there, depth + 1, path);
        }
    }

    private static boolean isAllConnected() {
        for (int visitedIdx = 1; visitedIdx <= N; ++visitedIdx) {
            if (visited[visitedIdx] == false) {
                return false;
            }
        }
        return true;
    }
    private static void clearAll() {
        Arrays.fill(visited, false);
        A.clear();
        B.clear();
    }
}
