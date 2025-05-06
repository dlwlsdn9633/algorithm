package b_24267;

import java.io.*;

public class b_24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long ret = 0;
        int N = Integer.parseInt(br.readLine());
        if (N >= 2) {
            N -= 2;
            ret = (long)((long)N * (long)(N + 1) * (long)(N + 2)) / 6;
        }
        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.write(String.valueOf(3));
        bw.flush();
        bw.close();
        br.close();
    }
}
