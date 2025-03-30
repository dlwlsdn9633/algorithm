package b_5597;

import java.io.*;

public class b_5597 {
    private static boolean[] students = new boolean[31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 28; ++i) {
            int studentNumber = Integer.parseInt(br.readLine());
            students[studentNumber] = true;
        }

        for (int i = 1; i <= 30; ++i) {
            if (students[i] == false) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
