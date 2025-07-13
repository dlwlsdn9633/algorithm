package b_1259;

import java.io.*;

public class b_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            boolean ret = isPalindrome(str);
            if (ret) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
