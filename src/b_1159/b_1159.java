package b_1159;

import java.util.Scanner;

public class b_1159 {
    private static int alphabets[] = new int[26];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; ++i) {
            String str = scanner.nextLine();
            ++alphabets[str.charAt(0) - 'a'];
        }

        String result = "";
        for (int i = 0; i < alphabets.length; ++i) {
            if (alphabets[i] >= 5) {
                result += (char)(i + 'a');
            }
        }
        if ("".equals(result)) {
            result = "PREDAJA";
        }
        System.out.println(result);
    }
}
