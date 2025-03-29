package b_14681;

import java.io.*;

public class b_14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x > 0 && y > 0) {
            bw.write(String.valueOf(1));
        } else if (x < 0 && y > 0) {
            bw.write(String.valueOf(2));
        } else if (x < 0 && y < 0) {
            bw.write(String.valueOf(3));
        } else if (x > 0 && y < 0) {
            bw.write(String.valueOf(4));
        }

        bw.flush();
        bw.close();
    }
}
