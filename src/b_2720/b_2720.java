package b_2720;

import java.io.*;
import java.util.Arrays;

public class b_2720 {
    private static final int QUARTER = 25;
    private static final int DIME = 10;
    private static final int NICKEL = 5;
    private static final int PENNY = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int money = Integer.parseInt(br.readLine());
            calc(money, bw);
        }

        bw.flush();
        bw.close();
    }

    private static void calc(int money, BufferedWriter bw) throws IOException {
        int idx = 0;
        int[] ret = new int[4];
        Arrays.fill(ret, 0);

        while (money >= QUARTER) {
            ++ret[idx];
            money -= QUARTER;
        }
        ++idx;
        while (money >= DIME) {
            ++ret[idx];
            money -= DIME;
        }
        ++idx;
        while (money >= NICKEL) {
            ++ret[idx];
            money -= NICKEL;
        }
        ++idx;
        while (money >= PENNY) {
            ++ret[idx];
            money -= PENNY;
        }
        for (int ele : ret) {
            bw.write(ele + " ");
        }
        bw.write("\n");
    }
}
