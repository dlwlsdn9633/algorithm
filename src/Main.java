import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int n;
    private static ArrayList<Integer> v = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        String[] numbers = scanner.nextLine().split(" ");
        for (int i = 0; i < numbers.length; ++i) {
            v.add(Integer.parseInt(numbers[i]));
        }
        System.out.println(go(0, 0));
    }

    private static int go(int idx, int sum) {
        if (idx == n) {
            return check(sum);
        }
        return go(idx + 1, sum + v.get(idx)) + go(idx + 1, sum); // v.get(idx)를 선택한 경우 + v.get(idx)를 선택하지 않는 경우
    }
    private static int check(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n % 2 == 0) return 0;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}