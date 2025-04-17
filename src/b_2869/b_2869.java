package b_2869;

import java.io.*;

public class b_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int A = Integer.parseInt(conds[0]);
        int B = Integer.parseInt(conds[1]);
        int V = Integer.parseInt(conds[2]);


        int days = (V - A) / (A - B);
        ++days;
        bw.write(String.valueOf(days));
        bw.flush();
        bw.close();
    }
}
