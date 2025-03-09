package b_4949;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class b_4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals(".")) {
                break;
            }
            System.out.println(test(str));

        }
    }

    private static String test(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ')' && str.charAt(i) != '(' && str.charAt(i) != '[' && str.charAt(i) != ']') {
                continue;

            }

            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                char top = stack.peek();
                if (str.charAt(i) == ')' && top == '(') {
                    stack.pop();
                } else if (str.charAt(i) == ']' && top == '[') {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }
        return (stack.size() == 0) ? "yes" : "no";
    }
}
