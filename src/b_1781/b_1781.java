package b_1781;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b_1781 {
    private static ArrayList<Cost> costs = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String[] conds = br.readLine().split(" ");
            int deadline = Integer.parseInt(conds[0]);
            int cost = Integer.parseInt(conds[1]);
            costs.add(new Cost(deadline, cost));
        }
        costs.sort(new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                return o1.deadline - o2.deadline;
            }
        });
        for (int i = 0; i < costs.size(); ++i) {
            Cost currentCost = costs.get(i);
            pq.add(currentCost.cupNoodles);
            while (pq.size() > currentCost.deadline) {
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
        int deadline;
        int cupNoodles;
        public Cost(int deadline, int cupNoodles) {
            this.deadline = deadline;
            this.cupNoodles = cupNoodles;
        }
        @Override
        public String toString() {
            return "Cost{" +
                    "deadline=" + deadline +
                    ", cupNoodles=" + cupNoodles +
                    '}';
        }
    }
}
