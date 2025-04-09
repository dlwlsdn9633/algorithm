package b_2566;

import java.io.*;

public class b_2566 {
    private static int ret = Integer.MIN_VALUE;
    private static int retY;
    private static int retX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int y = 0; y < 9; ++y) {
            String[] row = br.readLine().split(" ");
            for (int x = 0; x < row.length; ++x) {
                int number = Integer.parseInt(row[x]);
                if (ret < number) {
                    ret = number;
                    retX = x + 1;
                    retY = y + 1;
                }
            }
        }
        bw.write(String.valueOf(ret));
        bw.write("\n");
        bw.write(retY + " " + retX);
        bw.flush();
        bw.close();
    }
}
