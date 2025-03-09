package b_2309;


import java.util.Arrays;
import java.util.Scanner;

public class b_2309_3_1 {
    private static int[] heights = new int[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < heights.length; ++i) {
            heights[i] = scanner.nextInt();
            scanner.nextLine();
        }
        Arrays.sort(heights);
        dfs(0);
    }
    private static void dfs(int depth) {
        if (depth >= 7) {
            int sum = getSum();
            if (sum == 100) {
                for (int i = 0 ; i < 7; ++i) {
                    System.out.println(heights[i]);
                }
                System.exit(0);
            }
            return;
        }

        for (int i = depth; i < heights.length; ++i) {
            swap(i, depth);
            dfs(depth + 1);
            swap(i, depth);
        }
    }
    private static void swap(int i, int j) {
        int temp = heights[i];
        heights[i] = heights[j];
        heights[j] = temp;
    }
    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < 7; ++i) {
            sum += heights[i];
        }
        return sum;
    }
}
