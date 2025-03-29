package b_1330;

import java.io.*;

public class b_1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int A = Integer.parseInt(conds[0]);
        int B = Integer.parseInt(conds[1]);
        bw.write((A > B) ? ">" : (A < B) ? "<" : "==");

        bw.flush();
        bw.close();
    }
}
