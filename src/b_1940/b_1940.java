package b_1940;

import java.util.Scanner;

public class b_1940 {
    private static int ingredients[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int M = scanner.nextInt();
        scanner.nextLine();

        String ingredientsStr = scanner.nextLine();
        String[] ingredientsArr = ingredientsStr.split(" ");
        ingredients = new int[ingredientsArr.length];

        for (int i = 0; i < ingredientsArr.length; ++i) {
            ingredients[i] = Integer.valueOf(ingredientsArr[i]);
        }

        int result = 0;
        for (int i = 0; i < ingredients.length; ++i) {
            for (int j = i + 1; j < ingredients.length; ++j) {
                if (ingredients[i] + ingredients[j] == M) {
                    ++result;
                }
            }
        }
        System.out.println(result);
    }
}
