package b_3986;

import java.util.Scanner;
import java.util.Stack;

public class b_3986_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        int answer = 0;
        for (int n = 0; n < N; ++n) {
            String str = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); ++i) {
                if (stack.isEmpty()) {
                    stack.push(str.charAt(i));
                } else {
                    Character top = stack.peek();
                    if (top == str.charAt(i)) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                }
            }
            if (stack.size() == 0) {
                ++answer;
            }
        }
        System.out.println(answer);
    }
}
