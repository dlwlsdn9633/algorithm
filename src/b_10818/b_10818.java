package b_10818;

import java.io.*;
import java.util.Arrays;

public class b_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(row[i]);
        }
        int maxValue = Arrays.stream(arr).max().getAsInt();
        int minValue = Arrays.stream(arr).min().getAsInt();

        bw.write(String.valueOf(minValue));
        bw.write(" ");
        bw.write(String.valueOf(maxValue));

        bw.flush();
        bw.close();
    }
}
