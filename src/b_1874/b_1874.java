package b_1874;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class b_1874 {
    private static int[] inputs;
    private final static List<Character> answerList = new ArrayList<>();
    private final static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        int inputsIdx = 0;
        boolean isFail = false;
        while (inputsIdx < N) {
            if (stack.isEmpty()) {
                if (num > inputs[inputsIdx]) {
                    isFail = true;
                    break;
                }
                answerList.add('+');
                stack.push(num++);
                continue;
            }
            if (stack.peek() == inputs[inputsIdx]) {
                answerList.add('-');
                stack.pop();
                ++inputsIdx;
            } else {
                if (stack.peek() < inputs[inputsIdx]) {
                    stack.push(num++);
                    answerList.add('+');
                } else {
                    stack.pop();
                    answerList.add('-');
                }
            }
        }


        if (isFail) {
            System.out.println("NO");
        } else {
            for (Character op : answerList) {
                System.out.println(op);
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
