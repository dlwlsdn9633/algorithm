package b_1546;

import java.io.*;
import java.util.Arrays;

public class b_1546 {
    private static double[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] scoreConds = br.readLine().split(" ");
        scores = new double[N];
        for (int i = 0; i < N; ++i) {
            scores[i] = Double.parseDouble(scoreConds[i]);
        }
        double maxScore = Arrays.stream(scores).max().getAsDouble();
        for (int i = 0; i < N; ++i) {
            scores[i] = (scores[i] / maxScore) * 100;
        }

        double avg = Arrays.stream(scores).average().getAsDouble();
        bw.write(String.valueOf(avg));

        bw.flush();
        bw.close();
    }
}
