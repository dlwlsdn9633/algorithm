package b_2941;

import java.io.*;

public class b_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int idx = 0;
        int ret = 0;
        while (idx < str.length()) {
            char currentChar = str.charAt(idx);
            if (currentChar == 'c') {
                if (idx + 1 < str.length() && (str.charAt(idx + 1) == '-' || str.charAt(idx + 1) == '=')) {
                    idx += 2;
                    ++ret;
                } else {
                    ++idx;
                    ++ret;
                }
            } else if (currentChar == 'd') {
                if (idx + 1 < str.length() && str.charAt(idx + 1) == '-') {
                    idx += 2;
                    ++ret;
                } else if (idx + 2 < str.length() && str.charAt(idx + 1) == 'z' && str.charAt(idx + 2) == '=') {
                    idx += 3;
                    ++ret;
                } else {
                    ++ret;
                    ++idx;
                }
            } else if (currentChar == 'l') {
                if (idx + 1 < str.length() && str.charAt(idx + 1) == 'j') {
                    idx += 2;
                    ++ret;
                } else {
                    ++ret;
                    ++idx;
                }
            } else if (currentChar == 'n') {
                if (idx + 1 < str.length() && str.charAt(idx + 1) == 'j') {
                    idx += 2;
                    ++ret;
                } else {
                    ++ret;
                    ++idx;
                }
            } else if (currentChar == 's') {
                if (idx + 1 < str.length() && str.charAt(idx + 1) == '=') {
                    idx += 2;
                    ++ret;
                } else {
                    ++ret;
                    ++idx;
                }
            } else if (currentChar == 'z') {
                if (idx + 1 < str.length() && str.charAt(idx + 1) == '=') {
                    idx += 2;
                    ++ret;
                } else {
                    ++ret;
                    ++idx;
                }
            } else {
                ++ret;
                ++idx;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
