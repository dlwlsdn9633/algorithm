package b_10808;

import java.util.Arrays;
import java.util.Scanner;

public class b_10808 {
    private static int alphabets[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        alphabets = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            ++alphabets[str.charAt(i) - 97];
        }
        for (int i = 0; i < alphabets.length; ++i) {
            System.out.print(alphabets[i] + " ");
        }
    }
}
