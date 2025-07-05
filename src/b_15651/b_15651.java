package b_15651;

import java.io.*;
import java.util.StringTokenizer;

public class b_15651 {
    private static int N;
    private static int M;
    private static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        dfs(0, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, BufferedWriter bw) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; ++i) {
                bw.write(answer[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int num = 1; num <= N; ++num) {
            answer[depth] = num;
            dfs(depth + 1, bw);
        }
    }
}
