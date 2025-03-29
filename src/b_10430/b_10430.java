package b_10430;

import java.io.*;

public class b_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        int A = Integer.parseInt(conds[0]);
        int B = Integer.parseInt(conds[1]);
        int C = Integer.parseInt(conds[2]);

        int ret1 = (A + B) % C;
        int ret2 = ((A % C) + (B % C)) % C;
        int ret3 = (A * B) % C;
        int ret4 = ((A % C) * (B % C)) % C;

        bw.write(String.valueOf(ret1));
        bw.write("\n");
        bw.write(String.valueOf(ret2));
        bw.write("\n");
        bw.write(String.valueOf(ret3));
        bw.write("\n");
        bw.write(String.valueOf(ret4));

        bw.flush();
        bw.close();
    }
}
