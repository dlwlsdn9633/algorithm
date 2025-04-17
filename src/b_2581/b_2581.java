package b_2581;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class b_2581 {
    private static int minValue;
    private static int maxValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        minValue = Integer.parseInt(br.readLine());
        maxValue = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int number = minValue; number <= maxValue; ++number) {
            if (isPrime(number)) {
                list.add(number);
            }
        }

        if (list.size() == 0) {
            bw.write(String.valueOf(-1));
        } else {
            int sum = list.stream().mapToInt(x->x).sum();
            bw.write(String.valueOf(sum));
            bw.newLine();
            bw.write(String.valueOf(list.get(0)));
        }
        bw.flush();
        bw.close();
    }

    private static boolean isPrime(int number) {
        int sum = 0;
        for (int num = 1; num < number; ++num) {
            if (number % num == 0) {
                ++sum;
            }
        }
        return sum == 1;
    }
}
