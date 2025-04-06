package b_25206;

import java.io.*;

public class b_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double totalGpa = 0.0;
        double totalScore = 0.0;
        for (int scoreIdx = 0; scoreIdx < 20; ++scoreIdx) {
            String[] conds = br.readLine().split(" ");
            if (conds[2].equals("P")) {
                continue;
            }
            if (conds[2].equals("A+")) {
                totalScore += (4.5 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("A0")) {
                totalScore += (4.0 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("B+")) {
                totalScore += (3.5 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("B0")) {
                totalScore += (3.0 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("C+")) {
                totalScore += (2.5 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("C0")) {
                totalScore += (2.0 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("D+")) {
                totalScore += (1.5 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("D0")) {
                totalScore += (1.0 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            } else if (conds[2].equals("F")) {
                totalScore += (0.0 * Double.parseDouble(conds[1]));
                totalGpa += Double.parseDouble(conds[1]);
            }
        }

        double avg = totalScore / totalGpa;
        bw.write(String.valueOf(avg));

        bw.flush();
        bw.close();
    }
}
