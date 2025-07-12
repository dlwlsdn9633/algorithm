package b_2920;

import java.io.*;
import java.util.StringTokenizer;

public class b_2920 {
    private static int[] music = new int[8];
    private static int[] dp = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < music.length; ++i) {
            music[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < music.length - 1; ++i) {
            if (music[i] < music[i + 1]) {
                ++dp[0];
            } else {
                --dp[1];
            }
        }
        if (dp[0] != 0 && dp[1] == 0) {
            bw.write("ascending");
        } else if (dp[0] == 0 && dp[1] != 0) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
