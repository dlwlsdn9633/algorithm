package b_12869;

import java.io.*;

public class b_12869_2 {
    private static final int FIRST_ATTACK = 9;
    private static final int SECOND_ATTACK = 3;
    private static final int THIRD_ATTACK = 1;
    private static int N;
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] scvs = new int[3];
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            scvs[i] = Integer.parseInt(conds[i]);
        }
        dfs(scvs[0], scvs[1], scvs[2], 0);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void dfs(int s1, int s2, int s3, int depth) {
        s1 = (s1 < 0) ? 0 : s1;
        s2 = (s2 < 0) ? 0 : s2;
        s3 = (s3 < 0) ? 0 : s3;

        if (s1 + s2 + s3 == 0) {
            ret = Math.min(ret, depth);
            return;
        }

        dfs(s1 - FIRST_ATTACK, s2 - SECOND_ATTACK, s3- THIRD_ATTACK, depth + 1);
        dfs(s1 - FIRST_ATTACK, s2 - THIRD_ATTACK, s3 - SECOND_ATTACK, depth + 1);
        dfs(s1 - SECOND_ATTACK, s2 - FIRST_ATTACK, s3 - THIRD_ATTACK, depth + 1);
        dfs(s1 - SECOND_ATTACK, s2 - THIRD_ATTACK, s3 - FIRST_ATTACK, depth + 1);
        dfs(s1 - THIRD_ATTACK, s2 - FIRST_ATTACK, s3 - SECOND_ATTACK, depth + 1);
        dfs(s1 - THIRD_ATTACK, s2 - SECOND_ATTACK, s3 - FIRST_ATTACK, depth + 1);
    }
}
