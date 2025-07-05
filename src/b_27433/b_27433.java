package b_27433;

import java.io.*;

public class b_27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long number = Long.parseLong(br.readLine());
        long ret = dfs(number);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static long dfs(long number) {
        if (number == 0L) {
            return 1L;
        }
        if (number == 1L) {
            return 1L;
        }
        return number * dfs(number - 1);
    }
}
