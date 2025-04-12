package b_1781;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b_1781_2 {
    private static ArrayList<Problem> arr = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            String[] conds = br.readLine().split(" ");
            arr.add(new Problem(Integer.parseInt(conds[0]), Integer.parseInt(conds[1])));
        }

        arr.sort(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if (o1.deadline == o2.deadline) {
                    return o2.ramen - o1.ramen;
                }
                return o1.deadline - o2.deadline;
            }
        });


        for (int i = 0; i < arr.size(); ++i) {
            Problem currentProblem = arr.get(i);
            int limit = currentProblem.deadline;
            if (pq.size() == 0 || pq.size() < limit) {
                pq.add(currentProblem.ramen);
                continue;
            }
            if (pq.peek() < arr.get(i).ramen) {
                pq.poll();
                pq.add(currentProblem.ramen);
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
    static class Problem {
        int deadline;
        int ramen;
        public Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }
        @Override
        public String toString() {
            return "Problem{" +
                    "deadline=" + deadline +
                    ", ramen=" + ramen +
                    '}';
        }
    }
}
