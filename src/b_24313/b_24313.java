package b_24313;

import java.io.*;
import java.util.StringTokenizer;

public class b_24313 {
    private static int[] ns = new int[2];
    private static int c;
    private static int n0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ns[0] = Integer.parseInt(st.nextToken());
        ns[1] = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());

        boolean isValid = true;
        for (int n = n0; n <= 100; ++n) {
            int ret = ns[0] * n + ns[1];
            if (ret > c * n) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            bw.write(String.valueOf(1));
        } else {
            bw.write(String.valueOf(0));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
