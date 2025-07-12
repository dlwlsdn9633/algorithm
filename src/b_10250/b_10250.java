package b_10250;

import java.io.*;
import java.util.StringTokenizer;

public class b_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int ho = N % H == 0 ? N / H : (N / H) + 1;
            int floor = N % H == 0 ? H : (N % H);

            String ret = floor + String.valueOf(((ho > 9) ? ho : "0" + ho));
            bw.write(ret);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
