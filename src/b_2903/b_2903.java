package b_2903;

import java.io.*;
public class b_2903 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        long len = (long) (1 + Math.pow(2, N));
        long area = len * len;
        bw.write(String.valueOf(area));

        bw.flush();
        bw.close();
    }
}
