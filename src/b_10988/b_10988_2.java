package b_10988;

import java.util.Scanner;

public class b_10988_2 {
    private static String str;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();

        boolean isAnswer = true;
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length / 2; ++i) {
            if (strArr[i] != strArr[strArr.length - 1 - i]) {
                isAnswer = false;
                break;
            }
        }
        System.out.println(isAnswer ? 1 : 0);
    }
}
