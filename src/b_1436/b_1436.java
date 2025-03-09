package b_1436;

import java.util.Scanner;

public class b_1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        long rank = 0;
        long number = 666;
        while (true) {
            String strNumber = String.valueOf(number);
            if (strNumber.contains("666")) {
                ++rank;
            }
            if (rank == N) {
                break;
            }
            ++number;
        }
        System.out.println(number);
    }
}
