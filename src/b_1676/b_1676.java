package b_1676;

import java.io.*;

public class b_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            bw.write(String.valueOf(0));
        } else {
            int remainder2 = 0;
            int remainder5 = 0;
            for (int num = 1; num <= N; ++num) {
                int number = num;
                while (number % 2 == 0) {
                    ++remainder2;
                    number /= 2;
                }
                while (number % 5 == 0) {
                    ++remainder5;
                    number /= 5;
                }
            }
            bw.write(String.valueOf(Math.min(remainder2, remainder5)));
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
