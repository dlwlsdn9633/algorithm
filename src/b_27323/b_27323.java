package b_27323;
import java.io.*;
public class b_27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int ret = N * M;
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
}
