package b_2109;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b_2109_a {
    private static ArrayList<Cost> costs = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String[] conds = br.readLine().split(" ");
            int cost = Integer.parseInt(conds[0]);
            int day = Integer.parseInt(conds[1]);
            costs.add(new Cost(cost, day));
        }
        // 일자별로 정렬
        costs.sort(new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                return o1.day - o2.day;
            }
        });

        for (int i = 0; i < n; ++i) {
            pq.add(costs.get(i).cost);
            if (pq.size() > costs.get(i).day) {
                pq.poll();
            }
        }
        int ret = 0;
        while (pq.isEmpty() == false) {
            ret += pq.poll();
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
    static class Cost {
        int day;
        int cost;
        public Cost(int cost, int day) {
            this.day = day;
            this.cost = cost;
        }
    }
}
