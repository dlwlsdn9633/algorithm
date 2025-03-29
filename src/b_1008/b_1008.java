package b_1008;

import java.io.*;

public class b_1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] conds = br.readLine().split(" ");
        double ret = Double.parseDouble(conds[0]) / Double.parseDouble(conds[1]);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
}
