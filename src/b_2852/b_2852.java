package b_2852;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b_2852 {
    private static int scores[] = new int[3];
    private static int aWinSecond = 0;
    private static int bWinSecond = 0;
    private static Map<Integer, Integer> map = new HashMap<>();
    // key: team, value: time
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for (int n = 0; n < N; ++n) {
            String[] conds = scanner.nextLine().split(" ");
            int teamId = Integer.valueOf(conds[0]);
            String[] times = conds[1].split(":");
            int totalTime = (Integer.valueOf(times[0]) * 60) + Integer.valueOf(times[1]);
            map.put(totalTime, teamId);
        }


        for (int second = 0; second < 2880; ++second) {
            if (map.get(second) != null) {
                ++scores[map.get(second)];
            }
            if (scores[1] > scores[2]) {
                ++aWinSecond;
            } else if (scores[1] < scores[2]) {
                ++bWinSecond;
            }
        }

        String aWinTime = "";
        if ((aWinSecond / 60) >= 0 && (aWinSecond / 60) <= 9) {
            aWinTime = "0" + String.valueOf(aWinSecond / 60) + ":";
        } else {
            aWinTime = String.valueOf(aWinSecond / 60) + ":";
        }

        if ((aWinSecond % 60) >= 0 && (aWinSecond % 60) <= 9) {
            aWinTime += ("0" + String.valueOf(aWinSecond % 60));
        } else {
            aWinTime += (String.valueOf(aWinSecond % 60));
        }


        String bWinTime = "";
        if ((bWinSecond / 60) >= 0 && (bWinSecond / 60) <= 9) {
            bWinTime = "0" + String.valueOf(bWinSecond / 60) + ":";
        } else {
            bWinTime = String.valueOf(bWinSecond / 60) + ":";
        }

        if ((bWinSecond % 60) >= 0 && (bWinSecond % 60) <= 9) {
            bWinTime += ("0" + String.valueOf(bWinSecond % 60));
        } else {
            bWinTime += (String.valueOf(bWinSecond % 60));
        }

        System.out.println(aWinTime);
        System.out.println(bWinTime);
    }
}
