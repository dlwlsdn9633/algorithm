package b_2309;

import java.util.Arrays;
import java.util.Scanner;

public class b_2309_3_2 {
    private static int heights[] = new int[9];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < heights.length; ++i) {
            heights[i] = scanner.nextInt();
            scanner.nextLine();
        }
        Arrays.sort(heights);
        int sum = Arrays.stream(heights).sum();

        for (int i = 0; i < heights.length; ++i) {
            for (int j = i + 1; j < heights.length; ++j) {
                if (sum - heights[i] - heights[j] == 100) {
                    for (int z = 0; z < heights.length; ++z) {
                        if (i == z || j == z) {
                            continue;
                        }
                        System.out.println(heights[z]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
