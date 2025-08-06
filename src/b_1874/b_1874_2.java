package b_1874;

import java.io.*;
import java.util.Stack;

public class b_1874_2 {
    private static final Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int start = 0;
        for (int t = 0; t < T; ++t) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                for (int num = start + 1; num <= value; ++num) {
                    stack.add(num);
                    sb.append("+").append("\n");
                }
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
