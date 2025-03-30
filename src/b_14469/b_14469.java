package b_14469;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class b_14469 {
    private static ArrayList<Cow> cows = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String[] cowCond = br.readLine().split(" ");
            cows.add(new Cow(Integer.parseInt(cowCond[0]), Integer.parseInt(cowCond[1])));
        }
        cows.sort(new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                if (o1.testTime == o2.testTime) {
                    return o1.arriveTime - o2.arriveTime;
                }
                return o1.testTime - o2.testTime;
            }
        });

        int done = 0;
        int currentTime = 1;
        boolean[] visit = new boolean[N];
        for (currentTime = 1; currentTime <= Integer.MAX_VALUE; ++currentTime) {
            if (done == cows.size()) {
                break;
            }
            for (int cowIdx = 0; cowIdx < N; ++cowIdx) {
                if (visit[cowIdx]) {
                    continue;
                }
                if (cows.get(cowIdx).arriveTime <= currentTime) {
                    visit[cowIdx] = true;
                    int plusTime = cows.get(cowIdx).testTime - 1;
                    currentTime += plusTime;
                    ++done;
                    break;
                }
            }
        }
        bw.write(String.valueOf(currentTime));
        bw.flush();
        bw.close();
    }
    static class Cow {
        int arriveTime;
        int testTime;
        public Cow(int arriveTime, int testTime) {
            this.arriveTime = arriveTime;
            this.testTime = testTime;
        }
        @Override
        public String toString() {
            return "Cow{" +
                    "arriveTime=" + arriveTime +
                    ", testTime=" + testTime +
                    '}';
        }
    }
}
