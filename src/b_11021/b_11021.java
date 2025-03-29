package b_11021;

import java.io.*;

public class b_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            String[] conds = br.readLine().split(" ");
            int number1 = Integer.parseInt(conds[0]);
            int number2 = Integer.parseInt(conds[1]);
            int sum = number1 + number2;
            bw.write("Case #" + (t + 1) + ": " + sum);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
