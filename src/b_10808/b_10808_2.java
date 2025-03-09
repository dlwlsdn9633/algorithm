package b_10808;

import java.util.Arrays;
import java.util.Scanner;

public class b_10808_2 {
    private static String str;
    private static int[] alphabets = new int[26];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; ++i) {
            int idx = strArr[i] - 'a';
            ++alphabets[idx];
        }
        for (int i = 0; i < alphabets.length; ++i) {
            System.out.print(alphabets[i] + " ");
        }
    }
}
