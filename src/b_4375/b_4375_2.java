package b_4375;

import java.util.Scanner;

public class b_4375_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int m = scanner.nextInt();
            long r = 0;
            long n = 0;

            scanner.nextLine();
            while (true) {
                n = (n * 10 + 1) % m;
                ++r; // 위의 계산을 수행하면, 1자리씩 올라가기 때문에, ++r을 수행한다.
                if (n == 0) {
                    System.out.println(r);
                    break;
                }
            }
        }
    }
}
