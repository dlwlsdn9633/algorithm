package b_2444;

import java.io.*;

public class b_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 위
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < N - y - 1; ++x) {
                bw.write(" ");
            }
            for (int x = 0; x < 1 + 2 * y; ++x) {
                bw.write("*");
            }
            bw.write("\n");
        }

        // 아래
        for (int y = 0; y < N - 1; ++y) {
            for (int x = 0; x <= y; ++x) {
                bw.write(" ");
            }
            for (int x = (2 * N - 3) - 2 * y; x > 0; --x) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
