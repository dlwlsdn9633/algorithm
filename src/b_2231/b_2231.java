package b_2231;

import java.io.*;

public class b_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ret = 0;
        int N = Integer.parseInt(br.readLine());
        for (int num = 1; num <= N; ++num) {
            int sumParts = getSumParts(num);
            if (num + sumParts == N) {
                ret = num;
                break;
            }
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static int getSumParts(int number) {
        int sum = 0;
        while (number > 0) {
            int remainder = number % 10;
            sum += remainder;
            number /= 10;
        }
        return sum;
    }
}
