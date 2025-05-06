package b_13913;

import java.io.*;
import java.util.*;

public class b_13913_2 {
    private static final int MAX_LEN = 100_000;
    private static int[] dp = new int[MAX_LEN + 1];
    private static int[] prevDp = new int[MAX_LEN + 1];
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(prevDp, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp[N] = 0; // 그동안 몇 칸을 움직였는지를 저장한다.
        q.add(N);
        while (q.isEmpty() == false) {
            int currentPos = q.poll();
            if (currentPos == K) {
                break;
            }
            for (int nextPos : List.of(currentPos + 1, currentPos - 1, 2 * currentPos)) {
                if (nextPos < 0 || nextPos > MAX_LEN) {
                    continue;
                }
                if (dp[nextPos] != Integer.MAX_VALUE) {
                    continue;
                }
                dp[nextPos] = dp[currentPos] + 1;
                prevDp[nextPos] = currentPos;
                q.add(nextPos);
            }
        }
        bw.write(String.valueOf(dp[K]));
        List<Integer> stepList = new ArrayList<>();
        stepList.add(K);
        int stepIdx = K;
        while (prevDp[stepIdx] != -1) {
            stepList.add(prevDp[stepIdx]);
            stepIdx = prevDp[stepIdx];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = stepList.size() - 1; i >= 0; --i) {
            sb.append(stepList.get(i) + " ");
        }
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
