package b_11720;

import java.io.*;

public class b_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int n = 0; n < N; ++n) {
            sum += (int)(str.charAt(n) - '0');
        }
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}
