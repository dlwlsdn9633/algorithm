package b_1085;

import java.io.*;
import java.util.Arrays;
public class b_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int x = Integer.parseInt(conds[0]);
        int y = Integer.parseInt(conds[1]);
        int w = Integer.parseInt(conds[2]);
        int h = Integer.parseInt(conds[3]);
        int[] intConds = { x, y, Math.abs(w - x), Math.abs(y - h) };
        int ret = Arrays.stream(intConds).min().getAsInt();
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
