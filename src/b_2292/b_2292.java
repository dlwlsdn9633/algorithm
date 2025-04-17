package b_2292;

import java.io.*;
public class b_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        int num = 1;
        int idx = 1;
        while (num < number) {
            num = num + (idx * 6);
            ++idx;
        }
        bw.write(String.valueOf(idx));
        bw.flush();
        bw.close();
    }
}
