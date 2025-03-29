package b_2109;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b_2109_2 {
    private static ArrayList<Lecture> lectures = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String[] conds = br.readLine().split(" ");
            lectures.add(new Lecture(Integer.parseInt(conds[0]), Integer.parseInt(conds[1])));
        }

        lectures.sort(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o1.day - o2.day;
            }
        });

        for (Lecture lecture : lectures) {
            int limitPqSize = lecture.day;
            pq.add(lecture.earn);
            while (limitPqSize < pq.size()) {
                pq.poll();
            }
        }
        int sum = 0;
        while (pq.size() != 0) {
            sum += pq.poll();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    static class Lecture {
        int earn;
        int day;
        public Lecture(int earn, int day) {
            this.earn = earn;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "earn=" + earn +
                    ", day=" + day +
                    '}';
        }
    }
}
