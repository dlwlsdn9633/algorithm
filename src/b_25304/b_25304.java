package b_25304;

import java.io.*;

public class b_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long X = Long.parseLong(br.readLine());
        long totalCost = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            String[] conds = br.readLine().split(" ");
            long money = Long.parseLong(conds[0]);
            long amount = Long.parseLong(conds[1]);
            long cost = money * amount;
            totalCost += cost;
        }
        if (totalCost == X) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
        bw.close();
    }
}
