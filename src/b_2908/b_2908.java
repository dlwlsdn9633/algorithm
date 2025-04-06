package b_2908;

import java.io.*;

public class b_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        char[] str1 = conds[0].toCharArray();
        char[] str2 = conds[1].toCharArray();

        reversedStr(str1);
        reversedStr(str2);

        String reveresedStr1 = String.valueOf(str1);
        String reveresedStr2 = String.valueOf(str2);
        int reversedNum1 = Integer.parseInt(reveresedStr1);
        int reversedNum2 = Integer.parseInt(reveresedStr2);

        int ret = (reversedNum1 > reversedNum2) ? reversedNum1 : reversedNum2;
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }

    private static void reversedStr(char[] str1) {
        for (int i = 0; i < str1.length / 2; ++i) {
            char temp = str1[i];
            str1[i] = str1[str1.length - 1 - i];
            str1[str1.length - 1 - i] = temp;
        }
    }
}
