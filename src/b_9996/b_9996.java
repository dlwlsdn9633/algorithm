package b_9996;


import java.util.Scanner;

public class b_9996 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        String pattern = scanner.nextLine();
        String[] candidates = new String[N];
        for (int i = 0; i < N; ++i) {
            candidates[i] = scanner.nextLine();
        }

        String[] splitedPatterns = pattern.split("\\*");
        String firstSplitedStr = splitedPatterns[0];
        String lastSplitedStr = splitedPatterns[1];

        String[] results = new String[N];

        for (int i = 0; i < N; ++i) {

            if (firstSplitedStr.length() + lastSplitedStr.length() > candidates[i].length()) {
                results[i] = "NE";
                continue;
            }

            boolean canMatch = (candidates[i].length() >= firstSplitedStr.length() && candidates[i].length() >= lastSplitedStr.length());
            if (canMatch) {
                boolean firstMatch = false;
                boolean lastMatch = false;

                String subFirstStr = candidates[i].substring(0, firstSplitedStr.length());
                if (subFirstStr.equals(firstSplitedStr)) {
                    firstMatch = true;
                }

                String subLastStr = candidates[i].substring(candidates[i].length() - lastSplitedStr.length(), candidates[i].length());
                if (subLastStr.equals(lastSplitedStr)) {
                    lastMatch = true;
                }



                if (firstMatch && lastMatch) {
                    results[i] = "DA";
                } else {
                    results[i] = "NE";
                }
            } else {
                results[i] = "NE";
            }
        }

        for (int i = 0; i < N; ++i) {
            System.out.println(results[i]);
        }
    }
}
