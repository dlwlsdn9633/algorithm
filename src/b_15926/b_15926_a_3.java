package b_15926;

import java.io.*;
import java.util.Stack;

// 배열로 푸는 방법
public class b_15926_a_3 {
    private static int N;
    private static int[] dp;
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        dp = new int[N];
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.size() != 0) {
                dp[i] = dp[stack.peek()] = 1;
                stack.pop();
            }
        }
        int ret = 0;
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            if (dp[i] == 0) {
                cnt = 0;
            } else {
                ++cnt;
                ret = Math.max(ret, cnt);
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
