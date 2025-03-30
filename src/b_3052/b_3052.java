package b_3052;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class b_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numbers = new int[10];
        for (int i = 0; i < 10; ++i) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; ++i) {
            set.add(numbers[i] % 42);
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}
