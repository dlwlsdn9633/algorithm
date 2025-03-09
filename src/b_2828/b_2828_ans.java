package b_2828;

import java.util.Scanner;

public class b_2828_ans {
    private static int n;
    private static int m;
    private static int j;
    private static int l;
    private static int r;
    private static int temp;
    private static int ret;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");
        n = Integer.valueOf(conds[0]);
        m = Integer.valueOf(conds[1]);

        j = scanner.nextInt();
        scanner.nextLine();

        l = 1; // 일단 Left는 1이다.
        // apple이 떨어진다~
        for (int i = 0; i < j; ++i) {
            r = l + m - 1;
            temp = scanner.nextInt(); // 떨어지는 apple 위치
            scanner.nextLine();

            if (temp >= l && temp <= r) {
                continue; // 만약 apple이 바구니 안에 있으면 그냥 진행하기
            }

            if (temp < l) {
                // 만약 apple이 바구니 왼편에서 떨어진다면
                ret += (l - temp); // 바구니가 left - apple position만큼 이동하므로 ret에 더한다.
                l = temp; // temp로 바구니가 이동한다.
            } else {
                // 만약 apple이 바구니 오른편에서 떨어진다면
                ret += (temp - r); // 바구니가 applePosition - right만큼 이동한다.
                l += (temp - r); // 왼편 마찬가지로 applePosition - right한 만큼 이동한다.
            }
        }
        System.out.println(ret);
    }
}
