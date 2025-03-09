package b_2979;

import java.util.Scanner;

public class b_2979 {

    private static int[][] parkingTimes;
    private static int[] trucks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int maxTime = 0;
        parkingTimes = new int[3][2];
        for (int i = 0; i < parkingTimes.length; ++i) {
            parkingTimes[i][0] = scanner.nextInt(); // startTime
            parkingTimes[i][1] = scanner.nextInt(); // endTime
            if (maxTime < parkingTimes[i][1]) {
                maxTime = parkingTimes[i][1];
            }
        }

        trucks = new int[maxTime];
        for (int i = 0; i < parkingTimes.length; ++i) {
            for (int j = parkingTimes[i][0]; j < parkingTimes[i][1]; ++j) {
                ++trucks[j];
            }
        }

        int sum = 0;
        for (int i = 0; i < trucks.length; ++i) {
            switch (trucks[i]) {
                case 1:
                    sum += (A);
                    break;
                case 2:
                    sum += (B * 2);
                    break;
                case 3:
                    sum += (C * 3);
                    break;
            }
        }
        System.out.println(sum);
    }
}
