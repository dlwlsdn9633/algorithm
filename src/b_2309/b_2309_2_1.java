package b_2309;

import java.util.Arrays;
import java.util.Scanner;

public class b_2309_2_1 {
    private static int heights[] = new int[9];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < heights.length; ++i) {
            heights[i] = scanner.nextInt();
            scanner.nextLine();
        }
        //Arrays.sort(heights);
        permutation(0);
    }

    public static void permutation(int depth) {
        if (depth == 7) {
            int sum = getSum();
            if (sum == 100) {
                for (int i = 0; i < 7; ++i) {
                    System.out.println(heights[i]);
                }
                System.exit(0);
            }
            return;
        }

        for (int i = depth; i < 9; ++i) {
            swap(i, depth);
            permutation(depth + 1);
            swap(i, depth);
        }
    }

    private static void swap(int from, int to) {
        int temp = heights[from];
        heights[from] = heights[to];
        heights[to] = temp;
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < 7; ++i) {
            sum += heights[i];
        }
        return sum;
    }
}
