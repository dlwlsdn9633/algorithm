package b_15926;

import java.io.*;
import java.util.Stack;

// 배열을 이용해서 푸는 방법
public class b_15926_a_1 {
    private static int n;
    private static int[] d = new int[200001];
    private static int ret = 0;
    private static int cnt = 0;
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < n; ++i) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.size() != 0) {
                d[i] = d[stack.peek()] = 1;
                stack.pop();
            }
        }
        for (int i = 0; i < n; ++i) {
            if (d[i] != 0) {
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
}
