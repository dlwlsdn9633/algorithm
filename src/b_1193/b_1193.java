package b_1193;

import java.io.*;
public class b_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int k = 1;
        while (getValue(k) < N) {
            ++k;
        }
        int beforeNums = getValue(k - 1);
        int diff = N - beforeNums;
        if (k % 2 == 0) {
            int upperElement = 1 + (diff - 1);
            int bottomElement = k - (diff - 1);
            bw.write(upperElement + "/" + bottomElement);
        } else {
            int upperElement = k - (diff - 1);
            int bottomElement = 1 + (diff - 1);
            bw.write(upperElement + "/" + bottomElement);
        }
        bw.flush();
        bw.close();
    }

    private static int getValue(int k) {
        return 1 + (((k - 1) * (k + 2)) / 2);
    }
}
