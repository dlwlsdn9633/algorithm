package b_14405;

import java.io.*;

public class b_14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isPikachu = true;
        String str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == 'p') {
                if ((i + 1) < str.length() && str.substring(i, i + 2).equals("pi")) {
                    ++i;
                    continue;
                } else {
                    isPikachu = false;
                    break;
                }
            }
            if (str.charAt(i) == 'k') {
                if ((i + 1) < str.length() && str.substring(i, i + 2).equals("ka")) {
                    ++i;
                    continue;
                } else {
                    isPikachu = false;
                    break;
                }
            }
            if (str.charAt(i) == 'c') {
                if ((i + 2 < str.length() && str.substring(i, i + 3).equals("chu"))) {
                    i += 2;
                    continue;
                } else {
                    isPikachu = false;
                    break;
                }
            }
            isPikachu = false;
            break;
        }

        if (isPikachu) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }
}
