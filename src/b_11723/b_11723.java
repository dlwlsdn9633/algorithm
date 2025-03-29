package b_11723;

import java.io.*;

public class b_11723 {
    private static int x = 0;
    private static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; ++n) {
            String[] conds = br.readLine().split(" ");

            if (conds[0].equals("add")) {
                int num = (int) Math.pow(2, Integer.parseInt(conds[1]));
                x |= num;
            } else if (conds[0].equals("remove")) {
                int num = (int) Math.pow(2, Integer.parseInt(conds[1]));
                num = ~num;
                x &= num;
            } else if (conds[0].equals("check")) {
                int num = (int) Math.pow(2, Integer.parseInt(conds[1]));
                if ((x & num) != 0) {
                    bw.write(String.valueOf(1));
                    bw.write("\n");
                } else {
                    bw.write(String.valueOf(0));
                    bw.write("\n");
                }
            } else if (conds[0].equals("toggle")) {
                int num = (int) Math.pow(2, Integer.parseInt(conds[1]));
                x ^= num;
            } else if (conds[0].equals("all")) {
                int num = ~x;
                x |= num;
            } else if (conds[0].equals("empty")) {
                int num = ~x;
                x &= num;
            }
        }
        bw.flush();
        bw.close();
    }
}
