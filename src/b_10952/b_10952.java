package b_10952;

import java.io.*;

public class b_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] conds = br.readLine().split(" ");
            int a = Integer.parseInt(conds[0]);
            int b = Integer.parseInt(conds[1]);

            int sum = a + b;
            if (sum == 0) {
                break;
            }
            bw.write(String.valueOf(sum));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
