package b_11655;

import java.util.Scanner;

public class b_11655_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; ++i) {
            char c = strArr[i];
            if (c >= '1' && c <= '9') {
                continue;
            }
            if (c == ' ') {

                continue;
            }

            if (c >= 'A' && c <= 'Z') {
                char pwEle = (char)(c + 13);
                if (pwEle > 'Z') {
                    pwEle = (char)('A' + (pwEle - ('Z' + 1)));
                }
                strArr[i] = pwEle;
            }

            if (c >= 'a' && c <= 'z') {
                char pwEle = (char)(c + 13);
                if (pwEle > 'z') {
                    pwEle = (char)('a' + (pwEle - ('z' + 1)));
                }
                strArr[i] = pwEle;
            }
        }
        System.out.println(strArr);
    }
}
