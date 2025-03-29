package b_1000;

import java.io.*;

public class b_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        int sum = Integer.parseInt(conds[0]) + Integer.parseInt(conds[1]);
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}
