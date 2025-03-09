package b_1094;

import java.util.Scanner;
import java.util.Stack;

public class b_1094 {
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        scanner.nextLine();

        stack.push(64);
        while (getSum() != X) {
            int popElement = stack.peek();
            stack.pop();

            int cutElement = popElement / 2;
            if ((getSum() + cutElement) >= X) {
                stack.push(cutElement);
            } else {
                stack.push(cutElement);
                stack.push(cutElement);
            }
        }
        System.out.println(stack.size());
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < stack.size(); ++i) {
            sum += stack.get(i);
        }
        return sum;
    }
}
