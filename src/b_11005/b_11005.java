package b_11005;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class b_11005 {
    private static List<Character> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        long number = Long.valueOf(conds[0]);
        long divNumber = Long.valueOf(conds[1]);

        while (number != 0) {
            long remainder = number % divNumber;
            if (remainder >= 0 && remainder <= 9) {
                list.add((char)('0' + remainder));
            } else {
                char cret = (char)('A' + (remainder - 10));
                list.add(cret);
            }
            number /= divNumber;
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            bw.write(String.valueOf(list.get(i)));
        }

        bw.flush();
        bw.close();
    }
}
