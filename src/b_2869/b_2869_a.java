package b_2869;

import java.io.*;

public class b_2869_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ABV = br.readLine().split(" ");

        double A = Integer.parseInt(ABV[0]); // 낮동안 올라가는 길이
        double B = Integer.parseInt(ABV[1]); // 밤동안 미끄러지는 길이
        double V = Integer.parseInt(ABV[2]); // 나무 막대의 길이

        int X = (int) Math.ceil((V - B) / (A - B)); // 올라가는 데 걸리는 일 수

        bw.write(String.valueOf(X));
        bw.flush();
        bw.close();
    }
}
