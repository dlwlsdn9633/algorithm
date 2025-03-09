package b_2309;

import java.util.Arrays;
import java.util.Scanner;


// 출력: 일곱 난쟁이의 키를 오름차순으로 출력한다.
// "오름차순"이라는 말을 제대로 파악하지 못함
public class b_2309_2_2 {
    private static int heights[] = new int[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < heights.length; ++i) {
            heights[i] = scanner.nextInt();
            scanner.nextLine();
        }
        Arrays.sort(heights);
        combi();
    }

    private static void combi() {
        int sum = Arrays.stream(heights).sum();
        for (int i = 0; i < 9; ++i) {
            for (int j = i + 1; j < 9; ++j) {
                if (sum - heights[i] - heights[j] == 100) {
                    for (int k = 0; k < 9; ++k) {
                        if (k == i || k == j) {
                            continue;
                        }
                        System.out.println(heights[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
