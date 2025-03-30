package b_1931;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b_1931 {
    private static ArrayList<Time> timeList = new ArrayList<>();
    private static PriorityQueue<Time> timePq = new PriorityQueue<>(new Comparator<Time>() {
        @Override
        public int compare(Time o1, Time o2) {
            if (o1.endTime == o2.endTime) {
                return o1.startTime - o2.startTime;
            }
            return o1.endTime - o2.endTime;
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String[] timeCond = br.readLine().split(" ");
            int startTime = Integer.parseInt(timeCond[0]);
            int endTime = Integer.parseInt(timeCond[1]);
            timePq.add(new Time(startTime, endTime));
        }

        int ret = 0;
        int t = 0;
        while (timePq.isEmpty() == false) {
            Time topSchedule = timePq.peek();
            if (topSchedule.startTime >= t) {
                ++ret;
                t = topSchedule.endTime;
                timePq.poll();
            } else {
                timePq.poll();
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    static class Time {
        int startTime;
        int endTime;
        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
