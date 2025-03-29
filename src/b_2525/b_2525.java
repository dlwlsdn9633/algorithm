package b_2525;

import java.io.*;

public class b_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] times = br.readLine().split(" ");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        int C = Integer.parseInt(br.readLine());

        int currentMin = hour * 60 + min;
        int totalMin = currentMin + C;

        int answerMin = totalMin % 60;
        int answerHour = (totalMin / 60) % 24;

        bw.write(answerHour + " " + answerMin);
        bw.flush();
        bw.close();
    }
}
