package b_8958;

import java.io.*;

public class b_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            int sum = 0;
            int accm = 0;
            char[] scores = br.readLine().toCharArray();
            for (char s : scores) {
                if (s == 'O') {
                    ++accm;
                    sum += accm;
                } else {
                    accm = 0;
                }
            }
            bw.write(String.valueOf(sum));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
