package b_3003;

import java.io.*;

public class b_3003 {
    private static int[] normalPieces = { 1, 1, 2, 2, 2, 8 };
    private static int[] findPieces = new int[6];
    private static int[] ret = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        find(conds);
        for (int i = 0; i < normalPieces.length; ++i) {
            ret[i] = normalPieces[i] - findPieces[i];
        }
        for (int ele : ret) {
            bw.write(ele + " ");
        }
        bw.flush();
        bw.close();
    }
    private static void find(String[] conds) {
        for (int i = 0; i < conds.length; ++i) {
            findPieces[i] = Integer.parseInt(conds[i]);
        }
    }
}
