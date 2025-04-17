package b_9506;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class b_9506 {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == -1) {
                break;
            }
            for (int n = 1; n < number; ++n) {
                if (number % n == 0) {
                    list.add(n);
                }
            }
            int sum = list.stream().mapToInt(x->x).sum();
            if (sum == number) {
                StringBuilder sb = new StringBuilder();
                sb.append(number).append(" = ");
                for (int i = 0; i < list.size(); ++i) {
                    sb.append(list.get(i));
                    if (i < list.size() - 1) {
                        sb.append(" + ");
                    }
                }
                bw.write(sb.toString());
            } else {
                bw.write(number + " is NOT perfect.");
            }
            bw.newLine();
            list.clear();
        }
        bw.flush();
        bw.close();
    }
}
