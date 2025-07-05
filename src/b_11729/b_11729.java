package b_11729;

import java.io.*;

public class b_11729 {
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ret = (int)(Math.pow(2, N)) - 1;
        sb.append(ret).append("\n");
        dfs(N, 1, 2, 3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int N, int start, int tmp, int to) {
        if (N == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }
        dfs(N - 1, start, to, tmp);
        sb.append(start).append(" ").append(to).append("\n");
        dfs(N - 1, tmp, start, to);
    }
}
