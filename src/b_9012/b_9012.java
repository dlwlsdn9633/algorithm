package b_9012;

import java.util.Scanner;
import java.util.Stack;

public class b_9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int n = 0; n < N; ++n) {
            String str = scanner.nextLine();
            System.out.println(getResult(str));
        }
    }

    private static String getResult(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                Character top = stack.peek();
                if (top == '(' && str.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }
        return (stack.size() == 0) ? "YES" : "NO";
    }
}
