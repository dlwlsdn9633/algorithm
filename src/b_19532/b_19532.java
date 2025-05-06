package b_19532;

import java.io.*;

public class b_19532 {
    private static int[] constants = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConstants(br);

        int retX = -1;
        int retY = -1;
        for (int x = -999; x <= 999; ++x) {
            for (int y = -999; y <= 999; ++y) {
                boolean ret1 = constants[0] * x + constants[1] * y == constants[2];
                boolean ret2 = constants[3] * x + constants[4] * y == constants[5];
                if (ret1 && ret2) {
                    retX = x;
                    retY = y;
                    break;
                }
            }
        }
        bw.write(retX + " " + retY);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setConstants(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            constants[i] = Integer.parseInt(conds[i]);
        }
    }
}
