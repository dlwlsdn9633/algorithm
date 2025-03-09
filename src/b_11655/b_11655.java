package b_11655;

import java.util.Scanner;

// 65 + (26 * x) = answer 에서 공식을 유도함
// x = (answer - 65) % 26

public class b_11655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        char[] strArr = str.toCharArray();
        for (int i = 0; i < str.length(); ++i) {

            boolean isSmallLetter = strArr[i] >= 65 && strArr[i] <= 90;
            boolean isBigLetter = strArr[i] >= 97 && strArr[i] <= 122;
            if (isSmallLetter || isBigLetter) {
                if (isSmallLetter) {
                    strArr[i] = (char)(65 + ((strArr[i] - 65 + 13) % 26));
                } else {
                    strArr[i] = (char)(97 + ((strArr[i] - 97 + 13) % 26));
                }
            }
        }
        System.out.println(strArr);
    }
}
