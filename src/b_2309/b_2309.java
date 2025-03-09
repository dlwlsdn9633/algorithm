package b_2309;

import java.util.Arrays;
import java.util.Scanner;

public class b_2309 {
    private static int heights[] = new int[9];
    private static boolean findAnswer = false;
    private static int selectedHeights[] = new int[7];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < heights.length; ++i) {
            heights[i] = scanner.nextInt();
        }
        for (int i = 0; i < selectedHeights.length; ++i) {
            selectedHeights[i] = 0;
        }
        Arrays.sort(heights);
        dfs(0);

    }

    private static void dfs(int depth) {
        if (findAnswer) {
            return;
        }
        // base 기저 조건
        if (depth >= selectedHeights.length) {
            int sum = getSum();
            if (sum == 100) {
                for (int i = 0; i < selectedHeights.length; ++i) {
                    System.out.println(selectedHeights[i]);
                }
                System.exit(0);
            }
        } else {
            for (int heightIdx = depth; heightIdx <  heights.length; ++heightIdx) {

                selectedHeights[depth] = heights[heightIdx];
                dfs(depth + 1);

            }
        }
    }

    private static int getSum () {
        int sum = 0;
        for (int i = 0; i < selectedHeights.length; ++i) {
            sum += selectedHeights[i];
        }
        return sum;
    }
}
