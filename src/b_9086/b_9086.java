package b_9086;

import java.io.*;

public class b_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String str = br.readLine();
            bw.write(str.charAt(0) + "" + str.charAt(str.length() - 1));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
