package b_24265;

import java.io.*;

public class b_24265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long ret = ((long)N * (long)(N - 1)) / 2L;
        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.write(String.valueOf(2));

        bw.flush();
        bw.close();
    }
}
