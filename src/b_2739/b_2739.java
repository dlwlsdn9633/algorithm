package b_2739;

import java.io.*;

public class b_2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; ++i) {
            bw.write(N + " * " + i + " = " + (N * i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
