package b_15926;

import java.io.*;
import java.util.Stack;

public class b_15926_a_2 {
    private static int n;
    private static int cnt;
    private static int ret;
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        stack.push(-1);
        for (int i = 0; i < n; ++i) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty() == false) {
                    ret = Math.max(ret, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
