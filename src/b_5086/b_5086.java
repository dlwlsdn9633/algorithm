package b_5086;

import java.io.*;

public class b_5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] conds = br.readLine().split(" ");
            int num1 = Integer.parseInt(conds[0]);
            int num2 = Integer.parseInt(conds[1]);
            if (num1 == 0 && num2 == 0) {
                break;
            }
            boolean isRelated = (num1 > num2) ? (num1 % num2) == 0 : (num2 % num1) == 0;
            if (isRelated) {
                if (num1 < num2) {
                    bw.write("factor\n");
                } else {
                    bw.write("multiple\n");
                }
            } else {
                bw.write("neither\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
