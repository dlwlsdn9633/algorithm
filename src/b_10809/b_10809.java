package b_10809;

import java.io.*;
import java.util.Arrays;

public class b_10809 {
    private static int[] dp = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.fill(dp, -1);
        String str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
            if (dp[str.charAt(i) - 'a'] == -1) {
                dp[str.charAt(i) - 'a'] = i;
            }
        }

        bw.write(String.join(" ", Arrays.stream(dp).mapToObj(String::valueOf).toArray(String[]::new)));
        bw.flush();
        bw.close();
    }
}
