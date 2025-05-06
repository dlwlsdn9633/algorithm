package b_1644;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class b_1644 {
    private static List<Integer> list = new ArrayList<>();
    private static int startPointer = 0;
    private static int endPointer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        for (int number = 2; number <= N; ++number) {
            if (isPrime(number)) {
                list.add(number);
            }
        }

        long sum = list.get(0);
        int ret = 0;
        while (endPointer < list.size() && startPointer <= endPointer) {
            if (sum < N) {
                ++endPointer;
                if (endPointer < list.size()) {
                    sum += list.get(endPointer);
                }
            } else if (sum > N) {
                sum -= list.get(startPointer++);
            } else {
                ++ret;
                ++endPointer;
                if (endPointer < list.size()) {
                    sum += list.get(endPointer);
                }
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
