package b_5073;

import java.io.*;
import java.util.Arrays;

public class b_5073 {
    private static int[] lens = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] conds = br.readLine().split(" ");
            for (int i = 0; i < lens.length; ++i) {
                lens[i] = Integer.parseInt(conds[i]);
            }
            if (lens[0] == 0 && lens[1] == 0 && lens[2] == 0) {
                break;
            }
            int sum = Arrays.stream(lens).sum();
            int maxVal = Arrays.stream(lens).max().getAsInt();
            if (maxVal < sum - maxVal) {
                if (lens[0] == lens[1] && lens[1] == lens[2]) {
                    bw.write("Equilateral");
                } else {
                    if (lens[0] == lens[1] || lens[1] == lens[2] || lens[0] == lens[2]) {
                        bw.write("Isosceles");
                    } else {
                        bw.write("Scalene");
                    }
                }
            } else {
                bw.write("Invalid");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
