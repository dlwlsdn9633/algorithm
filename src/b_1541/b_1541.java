package b_1541;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b_1541 {
    private final static List<Long> sumList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "-");

        while (st.hasMoreTokens()) {
            StringTokenizer subSt = new StringTokenizer(st.nextToken(), "+");
            long sum = 0;
            while (subSt.hasMoreTokens()) {
                int number = Integer.parseInt(subSt.nextToken());
                sum += (long) number;
            }
            sumList.add(sum);
        }
        long ret = sumList.get(0);
        for (int idx = 1; idx < sumList.size(); ++idx) {
            ret -= sumList.get(idx);
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
}
