package b_2828;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class b_2828 {
    private static int M;
    private static int N;
    private static int L;
    private static int R;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");
        N = Integer.valueOf(conds[0]);
        M = Integer.valueOf(conds[1]);
        L = 1;
        R = L + (M - 1);

        int ret = 0;
        int J = scanner.nextInt();
        scanner.nextLine();

        Queue<Integer> q = new ArrayDeque<>();
        for (int j = 0; j < J; ++j) {
            int applePosition = scanner.nextInt();
            scanner.nextLine();
            q.add(applePosition);
        }

        while (q.isEmpty() == false) {
            int ap = q.poll();
            if (isFullBasket(ap)) {
                continue;
            }
            boolean isLeft = (L > ap);
            if (isLeft) {
                while (L != ap) {
                    L--;
                    R--;
                    ++ret;
                }
            } else {
                while (R != ap) {
                    L++;
                    R++;
                    ++ret;
                }
            }
        }
        System.out.println(ret);
    }

    private static boolean isFullBasket(int ap) {
        return (ap >= L && ap <= R);
    }
}
