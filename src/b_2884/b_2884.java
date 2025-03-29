package b_2884;

import java.io.*;

public class b_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] times = br.readLine().split(" ");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        if (min >= 45) {
            min -= 45;
        } else {
            hour -= 1;
            if (hour < 0) {
                hour = 23;
            }
            min = (60 + (min - 45));
        }
        bw.write(hour + " " + min);
        bw.flush();
        bw.close();
    }
}
