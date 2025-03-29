package b_3015;

import java.io.*;
import java.util.Stack;

public class b_3015_a {
    private static long n;
    private static long ret;
    private static Stack<StackElement> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Long.parseLong(br.readLine());
        for (int i = 0; i < n; ++i) {
            long value = Long.parseLong(br.readLine());
            int cnt = 1;
            while (stack.isEmpty() == false && stack.peek().value <= value) {
                ret += stack.peek().cnt;
                if (stack.peek().value == value) {
                    cnt = stack.peek().cnt + 1;
                } else {
                    cnt = 1;
                }
                stack.pop();
            }
            // 내림차순할 때, 자신의 뒤에 있는 친구랑 짝짓기를 하기 위해
            // 4 <-> 3 (3이 4와 짝짓기를 하므로 1)
            if (stack.isEmpty() == false) {
                ++ret;
            }
            stack.push(new StackElement(value, cnt));
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    static class StackElement {
        long value;
        int cnt;
        public StackElement(long value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
}
