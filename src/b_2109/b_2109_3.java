package b_2109;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class b_2109_3 {
    private static int T;
    private static ArrayList<Lecture> arr = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            String[] conds = br.readLine().split(" ");
            int price = Integer.parseInt(conds[0]);
            int deadline = Integer.parseInt(conds[1]);
            arr.add(new Lecture(price, deadline));
        }
        arr.sort(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.deadline == o2.deadline) {
                    return o2.price - o1.price;
                }
                return o1.deadline - o2.deadline;
            }
        });
        for (Lecture lecture : arr) {
            if (pq.size() == 0 || pq.size() < lecture.deadline) {
                pq.add(lecture.price);
                continue;
            }
            if (pq.peek() <= lecture.price) {
                pq.poll();
                pq.add(lecture.price);
            }
        }
        int ret = pq.stream().mapToInt(x -> x).sum();
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
    static class Lecture {
        int price;
        int deadline;
        public Lecture(int price, int deadline) {
            this.price = price;
            this.deadline = deadline;
        }
        @Override
        public String toString() {
            return "Lecture{" +
                    "price=" + price +
                    ", deadline=" + deadline +
                    '}';
        }
    }
}
