package b_4659;

import java.util.Scanner;

public class b_4659_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            char[] strArr = str.toCharArray();

            if (str.equals("end")) {
                break;
            }

            boolean isVowelExisted = false;
            int flag = 0;
            int sequenceVowelNum = 0;
            int sequenceNotVowelNum = 0;
            int prev = -1;

            for (int i = 0; i < strArr.length; ++i) {
                if (isVowel(strArr[i])) {
                    ++sequenceVowelNum;
                    sequenceNotVowelNum = 0;
                    isVowelExisted = true;
                } else {
                    sequenceVowelNum = 0;
                    ++sequenceNotVowelNum;
                }
                if (sequenceVowelNum == 3 || sequenceNotVowelNum == 3) {
                    flag = 1;
                }
                if (i >= 1 && (prev == strArr[i]) && (strArr[i] != 'e' && strArr[i] != 'o')) {
                    flag = 1;
                }
                prev= strArr[i];
            }

            if (isVowelExisted == false) {
                flag = 1;
            }

            if (flag == 1) {
                System.out.println("<" + str + "> is not acceptable.");
            } else {
                System.out.println("<" + str + "> is acceptable.");
            }
        }
    }
    private static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
