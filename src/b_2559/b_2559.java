package b_2559;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class b_2559 {
    private static int temps[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();

        temps = new int[N];
        for (int tempIdx = 0; tempIdx < N; ++tempIdx) {
            temps[tempIdx] = scanner.nextInt();
        }
        scanner.nextLine();

        ArrayList<Integer> sumList = new ArrayList<>();
        for (int startDay = 0; startDay <= N - K; ++startDay) {
            int sum = getSum(startDay, K);
            sumList.add(sum);
        }

        System.out.println(sumList.stream().max(Comparator.comparing(x -> x)).get());
    }

    private static int getSum(int startDay, int K) {
        int sum = 0;
        for (int idx = startDay; idx < startDay + K; ++idx) {
            sum += temps[idx];
        }
        return sum;
    }
}
