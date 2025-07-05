package b_31403;

import java.io.*;

public class b_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int ret1 = A + B - C;

        String strA = String.valueOf(A);
        String strB = String.valueOf(B);
        String strAB = strA + strB;
        int ret2 = Integer.parseInt(strAB) - C;
        bw.write(String.valueOf(ret1));
        bw.newLine();
        bw.write(String.valueOf(ret2));

        bw.flush();
        bw.close();
        br.close();
    }
}
