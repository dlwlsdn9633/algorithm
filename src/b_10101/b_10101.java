package b_10101;

import java.io.*;

public class b_10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());

        if (x + y + z == 180) {
            if (x == y && y == z) {
                bw.write("Equilateral");
            } else {
                if (x == y || y == z || x == z) {
                    bw.write("Isosceles");
                } else {
                    bw.write("Scalene");
                }
            }
        } else {
            bw.write("Error");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
