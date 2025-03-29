package b_2439;

import java.io.*;

public class b_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int y = 0; y < N; ++y) {
            for(int x = N - 1; x > y; --x) {
                bw.write(" ");
            }
            for (int x = 0; x < y + 1; ++x) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
