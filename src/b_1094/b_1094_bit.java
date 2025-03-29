package b_1094;

import java.io.*;

public class b_1094_bit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int stick = 64;
        int rem = 0;
        int ret = 1;

        while (stick + rem != X) {
            stick = stick >> 1;
            if (stick + rem < X) {
                rem += stick;
                ++ret;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
