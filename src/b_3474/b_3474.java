package b_3474;


import java.util.Scanner;

public class b_3474 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        scanner.nextLine();
        for (int n = 0; n < N; ++n) {
            test(scanner);
        }
    }

    private static void test(Scanner scanner) {
        long twoResult = 0;
        long fiveResult = 0;
        long num = scanner.nextLong();
        scanner.nextLine();

        for (long i = 2; i <= num; i *= 2) {
            long ret = num / i;
            twoResult += ret;
        }
        for (long i = 5; i <= num; i *= 5) {
            long ret = num / i;
            fiveResult += ret;
        }
        System.out.println(fiveResult);
    }
}
