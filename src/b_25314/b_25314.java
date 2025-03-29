package b_25314;

import java.io.*;

public class b_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int longNum = N / 4;
        for (int i = 0; i < longNum; ++i) {
            bw.write("long ");
        }
        bw.write("int");
        bw.flush();
        bw.close();
    }
}
