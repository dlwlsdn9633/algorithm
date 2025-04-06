package b_10988;

import java.io.*;

public class b_10988_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isPal = true;
        String str = br.readLine();
        for (int i = 0; i < str.length() / 2; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                isPal = false;
                break;
            }
        }
        if (isPal) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }
}
