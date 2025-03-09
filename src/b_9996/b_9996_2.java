package b_9996;

import java.util.Scanner;

public class b_9996_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String pattern = scanner.nextLine();
        String[] patternArr = pattern.split("\\*");

        String firstPattern = patternArr[0];
        String lastPattern = patternArr[1];

        for (int i = 0; i < N; ++i) {
            String filename = scanner.nextLine();

            if (firstPattern.length() + lastPattern.length() > filename.length()) {
                System.out.println("NE");
                continue;
            }

            String first = filename.substring(0, firstPattern.length());
            String last = filename.substring(filename.length() - lastPattern.length(), filename.length());

            if (first.equals(firstPattern) && last.equals(lastPattern)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
