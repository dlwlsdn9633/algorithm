package b_1978;

import java.io.*;

public class b_1978 {
    private static int N;
    private static int[] numbers;
    private static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        for (int number : numbers) {
            int sum = 0;
            for (int i = 1; i < number; ++i) {
                if (number % i == 0) {
                    ++sum;
                }
            }
            if (sum == 1) {
                ++ret;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    private static void setConds (BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            numbers[i] = Integer.parseInt(conds[i]);
        }
    }
}
