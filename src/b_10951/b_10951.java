package b_10951;

import java.io.*;

public class b_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while ((input = br.readLine()) != null) {
            String[] conds = input.split(" ");
            int A = Integer.parseInt(conds[0]);
            int B = Integer.parseInt(conds[1]);
            bw.write(String.valueOf(A + B));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
