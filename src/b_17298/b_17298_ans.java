package b_17298;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class b_17298_ans {
    private static Stack<Integer> stack = new Stack<>();
    private static int N;
    private static int arr[];
    private static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        String[] elements = br.readLine().split(" ");
        for (int i = 0; i < elements.length; ++i) {
            arr[i] = Integer.parseInt(elements[i]);
        }
        Arrays.fill(dp, -1);
        for (int i = 0; i < N; ++i) {
            while (stack.size() != 0 && arr[stack.peek()] < arr[i]) {
                dp[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        for (int ele : dp) {
            bw.write(ele + " ");
        }
        bw.flush();
        bw.close();
    }
}
