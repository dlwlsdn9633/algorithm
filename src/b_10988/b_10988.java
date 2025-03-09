package b_10988;

import java.util.Scanner;

public class b_10988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        boolean result = true;
        for (int i = 0; i < str.length() / 2; ++i) {
            char firstLetter = str.charAt(i);
            char lastLetter = str.charAt(str.length() - 1 - i);

            if (firstLetter != lastLetter) {
                result = false;
                break;
            }
        }
        System.out.println(result ? 1 : 0);
    }
}
