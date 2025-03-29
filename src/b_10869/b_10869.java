package b_10869;

import java.io.*;

public class b_10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int sum = Integer.parseInt(conds[0]) + Integer.parseInt(conds[1]);
        int minus = Integer.parseInt(conds[0]) - Integer.parseInt(conds[1]);
        int cross = Integer.parseInt(conds[0]) * Integer.parseInt(conds[1]);
        int divide = Integer.parseInt(conds[0]) / Integer.parseInt(conds[1]);
        int mod = Integer.parseInt(conds[0]) % Integer.parseInt(conds[1]);

        bw.write(String.valueOf(sum));
        bw.write("\n");
        bw.write(String.valueOf(minus));
        bw.write("\n");
        bw.write(String.valueOf(cross));
        bw.write("\n");
        bw.write(String.valueOf(divide));
        bw.write("\n");
        bw.write(String.valueOf(mod));


        bw.flush();
        bw.close();
    }
}
