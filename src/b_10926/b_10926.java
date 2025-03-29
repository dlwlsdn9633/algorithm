package b_10926;

import java.io.*;

public class b_10926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        name += "??!";
        bw.write(name);

        bw.flush();
        bw.close();
    }
}
