package b_1003;

import java.io.*;

public class b_1003 {
    private static int[] zeros = new int[41];
    private static int[] ones = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        zeros[0] = 1;
        ones[0] = 0;
        zeros[1] = 0;
        ones[1] = 1;
        for (int i = 2; i <= 40; ++i) {
            zeros[i] = zeros[i - 1] + zeros[i - 2];
            ones[i] = ones[i - 1] + ones[i - 2];
        }


        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            int number = Integer.parseInt(br.readLine());
            bw.write(zeros[number] + " " + ones[number]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }


}
