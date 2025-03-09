package b_3986;

import java.util.Scanner;
import java.util.Stack;

public class b_3986 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        int answer = 0;
        for (int i = 0; i < N; ++i) {
            String str = scanner.nextLine();
            int result = test(str);

            if (result == 0) {
                ++answer;
            }
        }
        System.out.println(answer);
    }

    private static int test(String str) {
        Stack<Character> stack = new Stack<Character>();

        char[] strArr = str.toCharArray();
        for (int i = 0; i < str.length(); ++i) {
            if (stack.isEmpty()) {
                stack.push(strArr[i]);
                continue;
            }

            char ele = stack.peek();
            char compChar = strArr[i];
            if (ele == compChar) {
                stack.pop();
            } else {
                stack.push(strArr[i]);
            }
        }
        return stack.size();
    }
}
