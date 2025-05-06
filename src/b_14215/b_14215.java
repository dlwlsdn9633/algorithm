package b_14215;

import java.io.*;
import java.util.Arrays;

public class b_14215 {
    private static int[] lens = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < lens.length; ++i) {
            lens[i] = Integer.parseInt(conds[i]);
        }

        int sum = Arrays.stream(lens).sum();
        int max = Arrays.stream(lens).max().getAsInt();
        int twoLens = sum - max;
        if (twoLens <= max) {
            int modifiedLen = twoLens - 1;
            int ret = modifiedLen + twoLens;
            bw.write(String.valueOf(ret));
        } else {
            bw.write(String.valueOf(sum));
        }


        bw.flush();
        bw.close();
    }
}
