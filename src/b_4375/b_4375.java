package b_4375;

import java.util.Scanner;

public class b_4375 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            scanner.nextLine();

            long n = 1;
            long r = 1;
            while (true) {
                if (n % m != 0) {
                    n = ((n % m) * (10 % m) + (1 % m)) % m;

                    //n = (n * 10 + 1) % m;
                    ++r;
                } else {
                    break;
                }
            }
            System.out.println(r);
        }
    }
}
