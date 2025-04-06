package b_1152;

import java.io.*;
public class b_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().trim();
        String[] elements = str.split(" ");

        if (elements[0].equals("")) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(elements.length));
        }
        bw.flush();
        bw.close();
    }
}
