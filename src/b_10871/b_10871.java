package b_10871;

import java.io.*;

public class b_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        int N = Integer.parseInt(conds[0]);
        int X = Integer.parseInt(conds[1]);

        String[] row = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            if (Integer.parseInt(row[i]) < X) {
                bw.write(row[i] + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}
