package b_25501;

import java.io.*;

public class b_25501 {
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String s = br.readLine();
            int ret = recursion(s, 0, s.length() - 1);
            bw.write(ret + " " + answer);
            bw.newLine();
            answer = 0;
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static int recursion(String s, int l, int r) {
        ++answer;
        if (l >= r) {
            return 1;
        }
        if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        return recursion(s, l + 1, r - 1);
    }
}

