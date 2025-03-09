package b_2979;

import java.util.ArrayList;
import java.util.Scanner;

public class b_2979_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] timeCosts = scanner.nextLine().split(" ");

        int A = Integer.valueOf(timeCosts[0]);
        int B = Integer.valueOf(timeCosts[1]);
        int C = Integer.valueOf(timeCosts[2]);


        int maxTime = 0;
        ArrayList<Time> times = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            Time truckTime = new Time();
            String[] truckTimes = scanner.nextLine().split(" ");
            truckTime.startTime = Integer.valueOf(truckTimes[0]);
            truckTime.endTime = Integer.valueOf(truckTimes[1]);
            if (maxTime < truckTime.endTime) {
                maxTime = truckTime.endTime;
            }
            times.add(truckTime);
        }

        int trucks[] = new int[maxTime];
        for (Time time : times) {
            for (int t = time.startTime; t < time.endTime; ++t) {
                ++trucks[t];
            }
        }

        int answer = 0;
        for (int truck : trucks) {
            switch(truck) {
                case 1:
                    answer += (truck * A);
                    break;
                case 2:
                    answer += (truck * B);
                    break;
                case 3:
                    answer += (truck * C);
                    break;
            }
        }
        System.out.println(answer);
    }

    static class Time {
        public int startTime;
        public int endTime;
    }
}
