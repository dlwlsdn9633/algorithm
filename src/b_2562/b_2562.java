package b_2562;

import java.io.*;

public class b_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxValue = Integer.MIN_VALUE;
        int maxValueIdx = -1;

        for (int i = 0; i < 9; ++i) {
            int num = Integer.parseInt(br.readLine());
            if (maxValue < num) {
                maxValue = num;
                maxValueIdx = i + 1;
            }
        }

        bw.write(String.valueOf(maxValue));
        bw.write("\n");
        bw.write(String.valueOf(maxValueIdx));

        bw.flush();
        bw.close();
    }
}
