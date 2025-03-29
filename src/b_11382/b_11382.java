package b_11382;

import java.io.*;

public class b_11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        long A = Long.parseLong(conds[0]);
        long B = Long.parseLong(conds[1]);
        long C = Long.parseLong(conds[2]);

        long ret = A + B + C;
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
