package b_8393;

import java.io.*;

public class b_8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ret = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; ++i) {
            ret += i;
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
