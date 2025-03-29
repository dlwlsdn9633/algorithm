package b_18108;

import java.io.*;

public class b_18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(year - 543));

        bw.flush();
        bw.close();
    }
}
