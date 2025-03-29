package b_3015;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class b_3015 {
    private static Stack<Integer> stack = new Stack<>();
    private static ArrayList<Integer> heights = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (stack.peek() < num) {
                    heights.add(stack.size());
                    while (stack.size() != 0 && stack.peek() < num) {
                        stack.pop();
                    }
                } else if (stack.peek() == num) {
                    Stack<Integer> temp = new Stack<>();

                    if (heights.isEmpty()) {
                        heights.add(1);
                    } else {
                        heights.add(heights.get(heights.size() - 1) + 1);
                    }
                } else {
                    heights.add(1);
                }
                stack.push(num);
            }
        }
        if (heights.size() != 0) {
            int sum = heights.stream().mapToInt(x->x).sum();
            bw.write(String.valueOf(sum));
        } else {
            bw.write(String.valueOf(0));
        }
        bw.flush();
        bw.close();
    }
}
