package b_1001;

import java.io.*;

public class b_1001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int ret = Integer.parseInt(conds[0]) - Integer.parseInt(conds[1]);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
}
