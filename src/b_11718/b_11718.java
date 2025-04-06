package b_11718;

import java.io.*;

public class b_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
