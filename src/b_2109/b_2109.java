package b_2109;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class b_2109 {
    private static ArrayList<Cost> costs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String[] conds = br.readLine().split(" ");
            int cost = Integer.parseInt(conds[0]);
            int day = Integer.parseInt(conds[1]);
            costs.add(new Cost(day, cost));
        }

        costs.sort(new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                return o2.cost - o1.cost;
            }
        });
        costs.sort(new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                return o1.day - o2.day;
            }
        });

        System.out.println(costs);

        bw.flush();
        bw.close();
    }

    static class Cost {
        int day;
        int cost;
        public Cost(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Cost{" +
                    "day=" + day +
                    ", cost=" + cost +
                    '}';
        }
    }
}
