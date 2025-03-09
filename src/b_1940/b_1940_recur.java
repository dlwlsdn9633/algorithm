package b_1940;

import java.util.Scanner;

public class b_1940_recur {
    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] selectNumbers = new int[2];
    private static int result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        scanner.nextLine();
        numbers = new int[N];

        M = scanner.nextInt();
        scanner.nextLine();

        String ingredientStr = scanner.nextLine();
        String[] ingredients = ingredientStr.split(" ");
        for (int i = 0; i < ingredients.length; ++i) {
            numbers[i] = Integer.valueOf(ingredients[i]);
        }

        dfs(-1, 0);
        System.out.println(result);
    }
    private static void dfs(int startIdx, int depth) {
        if (depth >= 2) {
            if (selectNumbers[0] + selectNumbers[1] == M) {
                ++result;
            }
            return;
        }

        for (int i = startIdx + 1; i < numbers.length; ++i) {
            selectNumbers[depth] = numbers[i];
            dfs(i, depth + 1);
        }
    }
}
