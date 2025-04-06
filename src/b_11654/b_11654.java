package b_11654;

import java.io.*;

public class b_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char c = br.readLine().charAt(0);
        bw.write(String.valueOf((int)c));

        bw.flush();
        bw.close();
    }
}
