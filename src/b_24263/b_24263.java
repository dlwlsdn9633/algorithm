package b_24263;

import java.io.*;

public class b_24263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(N));
        bw.newLine();
        bw.write(String.valueOf(1));

        bw.flush();
        bw.close();
    }
}
