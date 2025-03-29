package b_15926;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class b_15926 {
    private static Stack<StackElement> stack = new Stack<>();
    private static int[] correctArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        correctArr = new int[n];

        String str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
            if (stack.size() == 0) {
                stack.push(new StackElement(str.charAt(i), i));
                continue;
            }
            if (str.charAt(i) == '(') {
                stack.push(new StackElement(str.charAt(i), i));
            } else {
                if (stack.peek().value == '(') {
                    correctArr[i] = 1;
                    correctArr[stack.peek().idx] = 1;
                    stack.pop();
                } else {
                    stack.push(new StackElement(str.charAt(i), i));
                }
            }
        }

        int cnt = 0;
        int ret = 0;
        for (int idx = 0; idx < correctArr.length; ++idx) {
            if (correctArr[idx] != 0) {
                ++cnt;
                ret = Math.max(ret, cnt);
            } else {
                cnt = 0;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    static class StackElement {
        char value;
        int idx;
        public StackElement(char value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
